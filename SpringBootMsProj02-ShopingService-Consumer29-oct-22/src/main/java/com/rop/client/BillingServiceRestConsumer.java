package com.rop.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {

	@Autowired 
	private DiscoveryClient client; // Comes through auto configuration  //client component
	//when there are multiple instances we will not use Discover client,    Load balancer client is there which is having less load factor.
	
	public String getBillingInfo() {
		// find and get service instance of producer by using service id
		List<ServiceInstance> listserins=client.getInstances("Billing-Service");
//		User first service instance from the List of instances (no load balancing)
		ServiceInstance si=listserins.get(0);
//		get producer MS URI and make it as URL
		String url=si.getUri()+"/billing/info";
//		Create RestTemplate object to consume the provider service
		RestTemplate rt=new RestTemplate();
//		invoke producer MS method or operation by generationg Http call
		String resp=rt.getForObject(url, String.class);
		return resp;
	}
	
}
