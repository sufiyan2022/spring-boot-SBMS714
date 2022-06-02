package com.rop.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_Posting_JSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
//	    Creates RestTemplate class Object
		RestTemplate template=new RestTemplate();
//		Define Service Url
		String serviceUrl="http://localhost:8080/actor/register";
		
//		Prepare JSON Data (request body)
		String json_body="{ \"aid\":1001,\"name\":\"ABU\",\"age\":18.0,\"type\":\"heor\"}";
		
//		Prepare Headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
//		Prepare HttpRequest as HttpEntity object having head,body
		HttpEntity<String> request=new HttpEntity<String>(json_body, headers);
		
//		make httpRequest call in post mode
		ResponseEntity<String> response=template.postForEntity(serviceUrl,request, String.class);// (url,request,output type)
		
//		display the received details from the response
		System.out.println("Response body(output) :"+response.getBody());
		System.out.println("Response header :"+response.getHeaders());
		System.out.println("Response status code value :"+response.getStatusCodeValue());
		System.out.println("Response status code ::"+response.getStatusCode().name());
		
//		System.exit(0);
 
		 
//		Object obj=template.getForObject(serviceUrl, String.class);
//		System.out.println("Response body (Output):"+obj);
		
//		System.exit(0);
		
	}

}
