/**
 * 
 */
package com.springboot.bank.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Audit;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.model.eventName;
import com.springboot.bank.model.eventType;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.CustomerDAO;
import com.springboot.bank.wrapper.WrapperBankCustomer;

/**
 * @author Sumit
 *
 */
@Service("customerService")
// @EnableBinding(RabbitService.class) used for annotation in rabitmq
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private BankDAO bankDao;

	/*
	 * @Autowired private AuditService auditService;
	 */

	/*
	 * @Autowired RabbitService rabbitService;
	 */

	@Autowired
	RabbitTemplate rabbitemplate;

	/*
	 * @MethodName : createCustomer. Description : It will create a new customer
	 * having bankId associated with it.
	 */
	@Override
	public Customer createCustomer(WrapperBankCustomer wrapperBankCustomer) throws BankException {
		Customer customer = null;
		Customer customerData = null;
		customer = wrapperBankCustomer.getCustomer();
		Long bankId = wrapperBankCustomer.getBankId();
		Optional<Bank> bankList = /* bankDao.findByBankId(bankId); */ null;
		Bank bank = bankList.get();
		customer.setBank(bank);
		customerData = customerDao.save(customer);
		return customerData;
	}

	/*
	 * @MethodName : getCustomerDetails. Description : It will take customerId as a
	 * parameter and find the details of a particular customer from it.
	 */
	@Override
	public Customer getCustomerDetails(Long customerId) throws BankException {
		Optional<Customer> customerList = customerDao.findByCustomerId(customerId);
		if (customerList.isPresent()) {
			Customer customer = customerList.get();
			return customer;
		} else {
			throw new BankException("Bank details not found");
		}
	}

	public static String fromJavaToJson(Audit audit)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.writeValueAsString(audit);
	}

	/*
	 * @MethodName : updateCustomerDetails. Description : It will take customerId as
	 * a parameter and find the details of a particular customer and update its
	 * details.
	 */
	@Override
	public Customer updateCustomerDetails(Long customerId) throws BankException, CloneNotSupportedException {
		Optional<Customer> customerList = customerDao.findByCustomerId(customerId);
		if (customerList.isPresent()) {
			Customer customer = customerList.get();
			Customer customerDummy = customer.clone();
			Audit audit = new Audit();
			audit.setTimestamp("");
			audit.setUuid("");
			audit.setEventName((eventName.CUSTOMER).toString());
			audit.setEventType((eventType.CREATE).toString());
			audit.setOldValue(customerDummy);
			customer.setCustomerName("Kira");
			audit.setNewValue(customer);
			// auditService.createAudit(audit); to call zuul to connect&pass to another
			// microservice

			String rabbitSendData = null;
			try {
				rabbitSendData = CustomerServiceImpl.fromJavaToJson(audit);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rabbitemplate.convertAndSend(RabbitServiceImpl.ROUTING_KEY, rabbitSendData);
			return customer;
		} else {
			throw new BankException("Bank details not found");
		}
	}
}
