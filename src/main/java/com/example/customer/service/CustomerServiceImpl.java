package com.example.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.customer.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	private ArrayList<Customer> customer = new ArrayList<Customer>();
	@Override
	public List<Customer> getCustomers() {
		return customer;
	}

	@Override
	public Customer getCustomer(int id) {
		List<Customer> result = customer.stream().filter(p->p.getId() == id).collect(Collectors.toList());
		return  result != null && result.size() > 0 ? result.get(0) : null;
	}

	@Override
	public void addCustomer(Customer c) {

		List<Customer> result = customer.stream().filter(p->p.getId() == c.getId()).collect(Collectors.toList());
		
		if(result != null && result.size() > 0) {
			customer.remove(result.get(0));
		}
		customer.add(c);
	}
}
