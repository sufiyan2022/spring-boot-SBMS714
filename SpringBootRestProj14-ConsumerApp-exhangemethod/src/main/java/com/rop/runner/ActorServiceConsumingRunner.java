package com.rop.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component 
public class ActorServiceConsumingRunner implements CommandLineRunner {

//	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------ActorServiceConsumingRunner----------");
		
//	    Creates RestTemplate class Object
		RestTemplate template=new RestTemplate();
//		Define Service Url
		String serviceUrl="http://localhost:8080/actor/wish";
		
//		Invoke the service using exchange(-) method.
		ResponseEntity<String> resp=template.exchange(serviceUrl, 
																								HttpMethod.GET, 
																								null, // no body for get mode request, and we dont want to pass any header value.
																								String.class);
		
//		Display the details
		System.out.println("Response status (output) :"+resp.getBody());
		System.out.println("Response status code :"+resp.getStatusCode());
		System.out.println("REsponse status code value :"+resp.getStatusCodeValue());
		System.out.println("Response heaser value :"+ resp.getHeaders());
		
		System.out.println("-----------------------------");
 
		
	}

}
