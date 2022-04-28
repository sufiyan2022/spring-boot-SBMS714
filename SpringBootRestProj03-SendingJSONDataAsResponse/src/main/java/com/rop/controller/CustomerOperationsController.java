package com.rop.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rop.model.Company;
import com.rop.model.Customer;

@RestController
public class CustomerOperationsController {

//	@GetMapping("/report")
//	public ResponseEntity<Customer> showData(){
//		Customer cust=new Customer(1001,"raja", 89999.f);
//		HttpStatus status=HttpStatus.OK;
//		return new ResponseEntity<Customer>(cust,status);
//	}
	
	@GetMapping("/report1")
	public ResponseEntity<Customer> showData1(){
//		body
		Customer cust=new Customer(1001,"raja", 89999.9f,
																new String[] {"red","green","blue"},
																List.of("10th", "10+2","B.Tech"),
																Set.of(987698L,7897899L,8008098L),
																Map.of("Adhar", 789078907890L, "PAN", 97989999L),
																new Company("WIPRO","BLORE","SOFTWARE",4000));
																
//				status
		HttpStatus status=HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}
}
