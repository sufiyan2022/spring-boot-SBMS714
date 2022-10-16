package com.rop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rop.entity.Customer;

@RestController
public class CustomerOperationsController {

	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer cust) {
		return cust.toString();
	}
	
	@PostMapping("/register1")
	public Customer registerCustomer1(@RequestBody Customer cust) {
		return cust;
	}
}
