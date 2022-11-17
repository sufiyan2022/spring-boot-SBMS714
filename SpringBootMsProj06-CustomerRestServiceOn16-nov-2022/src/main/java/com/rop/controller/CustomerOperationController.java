package com.rop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerOperationController {
	
	@Value("${dbuser}")
	private String user;
	
	@Value("${dbpassword}")
	private String password;
	
	@GetMapping("/display")
	public String displayData() {
		return "(Customer) Data Collected through Config Server :: "+user+"\t------"+password;
	}
}
