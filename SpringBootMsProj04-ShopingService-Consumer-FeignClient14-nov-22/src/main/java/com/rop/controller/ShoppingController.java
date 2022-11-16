package com.rop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rop.client.IBillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

	@Autowired
	private IBillingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	public String displayShoppingDetails() {
		System.out.println("ShoppingController:: client component class Name: "+consumer.getClass());
//		use client component
		return "Depawali Shopping for Family ...."+consumer.fetchBillDetails();
	}
}
