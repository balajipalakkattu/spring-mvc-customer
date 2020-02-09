package com.example.customer.service;

import java.util.List;

import com.example.customer.model.Customer;

public interface CustomerService {

	//list, show one customer, add a customer, update a customer, and delete a customer by id
	List<Customer> getCustomers();
	Customer getCustomer(int id);
	void addCustomer(Customer c);
	
}
