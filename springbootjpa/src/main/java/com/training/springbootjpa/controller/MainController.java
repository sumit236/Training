package com.training.springbootjpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.training.springbootjpa.model.Customer;
import com.training.springbootjpa.model.Goods;
import com.training.springbootjpa.model.Retailer;
import com.training.springbootjpa.model.Supplier;
import com.training.springbootjpa.repository.CustomerDAO;
import com.training.springbootjpa.service.CustomerService;
import com.training.springbootjpa.service.GoodsService;
import com.training.springbootjpa.service.RetailerService;
import com.training.springbootjpa.service.SupplierService;

@RestController
public class MainController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private RetailerService retailerService;

	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping(method = RequestMethod.POST, value = "/addCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	// @PostMapping(path = "/addCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		final Customer customerData;
		customerData = customerService.addCustomer(customer);
		return new ResponseEntity(customerData, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public ResponseEntity<Customer> deleteCustomer(@RequestBody List<Long> customerId) {
		Map<Long, String> mapList = null;
		try {
			System.out.println("abcd");
			mapList = customerService.deleteCustomerById(customerId);
			mapList.put((long) 1, "Null not allowed");
			System.out.println(mapList);
		} catch (Exception exception) {
			exception.getMessage();
		}
	
		return new ResponseEntity(mapList, HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/deleteMultipleCustomerNew", method =
	 * RequestMethod.POST) public ResponseEntity<Customer>
	 * deleteMultipleCustomerNew(@RequestBody List<Long> customerId) {
	 * System.out.println(">>>>" + customerId);
	 * 
	 * return new ResponseEntity("", HttpStatus.OK); }
	 */

	@RequestMapping(value = "/updateCustomer/{updateById}", method = RequestMethod.GET)
	public ResponseEntity<Customer> updateCustomer(@RequestBody List<Long> updateById) {
		final Map<Long, String> mapList;
		mapList = customerService.updateCustomerById(updateById);
		return new ResponseEntity(mapList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addGoods", produces = MediaType.APPLICATION_JSON_VALUE)
	// @PostMapping(path = "/addGoods")
	public ResponseEntity<Goods> createGoods(@RequestBody Goods goods) {
		// System.out.println(goods);
		final Goods goodsData;
		goodsData = goodsService.addGoods(goods);
		return new ResponseEntity(goodsData, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteGoods/{deleteById}", method = RequestMethod.GET)
	public ResponseEntity<Goods> deleteGoods(@PathVariable long deleteById) {
		final List goodsList;
		goodsList = goodsService.deleteGoodsById(deleteById);
		return new ResponseEntity(goodsList, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateGoods/{updateById}", method = RequestMethod.GET)
	public ResponseEntity<Goods> updateGoods(@PathVariable long updateById) {
		final Goods goods = goodsService.updateGoodsById(updateById);
		return new ResponseEntity(goods, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addSupplier", produces = MediaType.APPLICATION_JSON_VALUE)
	// @PostMapping(path = "/addSupplier")
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
		// System.out.println(supplier);
		final Supplier supplierData;
		supplierData = supplierService.addSupplier(supplier);
		return new ResponseEntity(supplierData, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteSupplier/{deleteById}", method = RequestMethod.GET)
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable long deleteById) {
		final List supplierList;
		supplierList = supplierService.deleteSupplierById(deleteById);
		return new ResponseEntity(supplierList, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateSupplier/{updateById}", method = RequestMethod.GET)
	public ResponseEntity<Supplier> updateSupplier(@PathVariable long updateById) {
		final Supplier supplier = supplierService.updateSupplierById(updateById);
		return new ResponseEntity(supplier, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addRetailer", produces = MediaType.APPLICATION_JSON_VALUE)
	// @PostMapping(path = "/addRetailer")
	public ResponseEntity<Supplier> createRetailer(@RequestBody Retailer retailer) {
		// System.out.println(retailer);
		final Retailer retailerData;
		retailerData = retailerService.addRetailer(retailer);
		return new ResponseEntity(retailerData, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteRetailer/{deleteById}", method = RequestMethod.GET)
	public ResponseEntity<Retailer> deleteRetailer(@PathVariable long deleteById) {
		final List retailerList;
		retailerList = retailerService.deleteRetailerById(deleteById);
		return new ResponseEntity(retailerList, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateRetailer/{updateById}", method = RequestMethod.GET)
	public ResponseEntity<Retailer> updateRetailer(@PathVariable long updateById) {
		final Retailer retailer = retailerService.updateRetailerById(updateById);
		return new ResponseEntity(retailer, HttpStatus.OK);
	}

	@RequestMapping(value = "/findByName/{customerName}", method = RequestMethod.GET)
	public ResponseEntity<Customer> findByCustomerName(@PathVariable String customerName) {
		final Customer customer = (Customer) customerDAO.findByCustomerName(customerName);
		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/findById/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<Customer> findByCustomerId(@PathVariable Long customerId) {
		Customer customer = (Customer) customerDAO.findByCustomerId(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
