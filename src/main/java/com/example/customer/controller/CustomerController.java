package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getAll() {
		return customerService.getCustomers();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomer(id);
	}
	
	@RequestMapping("/customer")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> addOrUpdate(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return customerService.getCustomers();
	}
}
