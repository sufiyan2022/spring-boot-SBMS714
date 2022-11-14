package com.rop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingServiceController {
	
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	@GetMapping("/info")
	public String getBillingInfo() {
		return "We Accept Card Payment, UPI Payment, NetBanking Payment, COD using--> "+instanceId +" @port: "+port;
	}
	
}
