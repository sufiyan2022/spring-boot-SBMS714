package com.rop.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner_PathVariables implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
//	    Creates RestTemplate class Object
		RestTemplate template=new RestTemplate();
//		Define Service Url
		String serviceUrl="http://localhost:8080/actor/wish/{id}/{name}";
		
		

//		Generate http request call with GET mode to consume the web service(API)
//		ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class,"1001","abu");
//		pass as Map
		ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class,Map.of("id", "1001", "name", "Mahad"));
//		display the received details from the response
		System.out.println("Response body(output) :"+response.getBody());
		System.out.println("Response status code value :"+response.getStatusCodeValue());
		System.out.println("Response header :"+response.getHeaders());
		System.out.println("Response status code ::"+response.getStatusCode().name());
		
//		System.exit(0);
 
		 
//		Object obj=template.getForObject(serviceUrl, String.class);
//		System.out.println("Response body (Output):"+obj);
		
//		System.exit(0);
		
	}

}
