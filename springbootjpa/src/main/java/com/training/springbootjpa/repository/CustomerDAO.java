package com.training.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springbootjpa.model.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {

	//Customer findByCustomerName(long findByName);
}
