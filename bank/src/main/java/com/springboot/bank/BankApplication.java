package com.springboot.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		
	/*	public void addCustomer() {
			final String url = "http://localhost:8080/addCustomer";
			 Bank bank;
			Customer customer = new  Customer("",421211 ,bank);
			RestTemplate restTemplate = new RestTemplate();
			String resultOfOperation = restTemplate.postForObject(url, customer, String.class);
			return resultOfOperation;
		}*/
	}
}
