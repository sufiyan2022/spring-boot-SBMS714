package com.rop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rop.entity.Customer;

@RestController
public class CustomerOperationsController {

	@GetMapping("/register")
	public String registerCustomer(@RequestBody Customer cust) {
		return cust.toString();
	}
}
