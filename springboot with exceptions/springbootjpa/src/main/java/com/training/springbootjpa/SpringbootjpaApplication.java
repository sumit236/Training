package com.training.springbootjpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.training.springbootjpa.model.Customer;

@SpringBootApplication
public class SpringbootjpaApplication {

	public String addCustomer() {
		final String url = "http://localhost:8080/addCustomer";
		Customer customer = new Customer("Sherlock Holmes", "Bakers Street", "CASH", "1L");
		RestTemplate restTemplate = new RestTemplate();
		String resultOfOperation = restTemplate.postForObject(url, customer, String.class);
		return resultOfOperation;
	}

	public Map deleteCustomer() {
		final String uri = "http://localhost:8080/deleteCustomer";
		List<Long> listOfId = new ArrayList<>();
		listOfId.add(80L);
		listOfId.add(85L);
		RestTemplate restTemplate = new RestTemplate();
		Map listResult = restTemplate.postForObject(uri, listOfId, Map.class);
		return listResult;
	}

	public Map updateCustomer() {
		final String uri = "http://localhost:8080/updateCustomer";
		List<Long> listOfId = new ArrayList<>();
		listOfId.add(78L);
		listOfId.add(82L);
		RestTemplate restTemplate = new RestTemplate();
		Map listResult = restTemplate.postForObject(uri, listOfId, Map.class);
		return listResult;
	}

	public Customer retrieveSingleCustomer() {
		final String uri = "http://localhost:8080/findById/78";
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(uri, Customer.class);
		return customer;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
		System.out.println("Hello world");
		SpringbootjpaApplication sjpaApp = new SpringbootjpaApplication();
		// sjpaApp.addCustomer();
		// sjpaApp.deleteCustomer();
		//System.out.println(sjpaApp.updateCustomer());
		System.out.println(sjpaApp.retrieveSingleCustomer());
	}
}
