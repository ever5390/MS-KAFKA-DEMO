package com.erosalesp.service;

import com.erosalesp.kafka.CustomerEventsService;
import org.springframework.stereotype.Service;

import com.erosalesp.entity.Customer;

@Service
public class CustomerService {
	
	private final CustomerEventsService customerEventsService;

	public CustomerService(CustomerEventsService customerEventsService) {
		super();
		this.customerEventsService = customerEventsService;
	}

	public Customer save(Customer customer) {
		System.out.println("Received " + customer);
		this.customerEventsService.publish(customer);
		return customer;
		
	}

}
