package com.rop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
//	    Creates RestTemplate class Object
		RestTemplate template=new RestTemplate();
//		Define Service Url
		String serviceUrl="http://localhost:8080/actor/wish";
//		Prepare http request headers
//		Generate http request call with GET mode to cunsume the web service(API)
		ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class);
//		display the received details from the response
		System.out.println("Response body(output) :"+response.getBody());
		System.out.println("Response status code value :"+response.getStatusCodeValue());
		System.out.println("Response status code ::"+response.getStatusCode().name());
		
//		System.exit(0);
	}

}
