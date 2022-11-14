package com.rop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingServiceController {

	@GetMapping("/info")
	public String getBillingInfo() {
		return "We Accept Card Payment, UPI Payment, NetBanking Payment, COD";
	}
	
//	@GetMapping("/info")
//	public ResponseEntity<String> getBillingInfo() {
//		String body= "We Accept Card Payment, UPI Payment, NetBanking Payment, COD";
//		return new ResponseEntity<String>(body, HttpStatus.OK);
//	}
}
