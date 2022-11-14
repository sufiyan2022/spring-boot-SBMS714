package com.rop.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {

	@Autowired 
	private LoadBalancerClient client; // Comes through auto configuration  //client component
	//when there are multiple instances we will use Discover client,    Load balancer client is there which is having less load factor.
	
	public String getBillingInfo() {
		// find and get service instance of producer (Billing-Service) by using service id based on load factor
		ServiceInstance instance=client.choose("Billing-Service");

//		get producer MS URI and make it as URL
		String url=instance.getUri()+"/billing/info";
		
//		Create RestTemplate object to consume the provider service
		RestTemplate rt=new RestTemplate();
//		invoke producer MS method or operation by generationg Http call
		String resp=rt.getForObject(url, String.class);
		return resp;
	}
	
}
