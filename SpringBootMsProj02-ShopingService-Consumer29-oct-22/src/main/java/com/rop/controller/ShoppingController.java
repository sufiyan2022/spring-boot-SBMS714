package com.rop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rop.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

	@Autowired
	private BillingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	public String displayShoppingDetails() {
//		use client component
		return "Depawali Shopping for Family ...."+consumer.getBillingInfo();
	}
}
