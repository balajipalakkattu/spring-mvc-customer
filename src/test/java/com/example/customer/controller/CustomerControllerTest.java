package com.example.customer.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerControllerTest {

	@Mock
	private CustomerService customerService;
	
	@InjectMocks
	private CustomerController customerController;
	
	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(customerService.getCustomers()).thenReturn(new ArrayList<Customer>() {{add(new Customer());}});
		
	}
	@org.junit.jupiter.api.Test
	public void getAll() {
		assertEquals("The controller and service are not same", 
				customerController.getAll(),
		customerService.getCustomers());
	}
	
}
