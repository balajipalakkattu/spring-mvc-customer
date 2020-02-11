package com.example.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;

@Service
@Profile("list")
public class CustomerServiceImpl implements CustomerService, ApplicationListener<ContextRefreshedEvent> {

	
	private void loadData() {

		Customer customer = new Customer();
		customer.setId(1);
		
		Customer customer2 = new Customer();
		customer2.setId(2);
		
		Customer customer3 = new Customer();
		customer3.setId(3);
		
		this.customer.add(customer);
		this.customer.add(customer2);
		this.customer.add(customer3);
	}

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

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.loadData();
		
	}
}
