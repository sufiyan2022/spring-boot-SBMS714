package com.rop.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rop.model.Actor;



@Component
public class ActorServiceConsuming_GettingJSONData_Runner implements CommandLineRunner {

//	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------ActorServiceConsuming_GettingJSONData_Runner----------");
		
//	    Creates RestTemplate class Object
		RestTemplate template=new RestTemplate();
//		Define Service Url
		String serviceUrl="http://localhost:8080/actor/find";
		
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
		
//		Converting JSON text response to java class object/ Model class object /Entity class object using JACKSON api
//		for this we have ObjectMapper concept
		
		String jsonBody=resp.getBody();
		
//		create ObjectMapper
		
		ObjectMapper mapper=new ObjectMapper();
		Actor actor=mapper.readValue(jsonBody,    //body
											Actor.class);					//required object type
		System.out.println("Response body as the Actor object data: "+actor);
		
		System.out.println("=========Multiple Actor Object===============");
		
//		Define Service Url
		serviceUrl="http://localhost:8080/actor/findAll";
		
//		Invoke the service using exchange(-) method.
		ResponseEntity<String> resp1=template.exchange(serviceUrl, 
																								HttpMethod.GET, 
																								null, // no body for get mode request, and we dont want to pass any header value.
																								String.class);
		
//		Display the details
		System.out.println("Response status (output) :"+resp1.getBody());
		System.out.println("Response status code :"+resp1.getStatusCode());
		System.out.println("REsponse status code value :"+resp1.getStatusCodeValue());
		System.out.println("Response heaser value :"+ resp1.getHeaders());
		
		System.out.println("-----------------------------");
//		Converting JSON text response to java class object/ Model class object /Entity class object using JACKSON api
//		for this we have ObjectMapper concept
		
		String jsonBody1=resp1.getBody();
		
//		create ObjectMapper
		
		ObjectMapper mapper1=new ObjectMapper();
//		List<Actor> actorsList=mapper1.readValue(jsonBody1,    //body
//											Actor.class);					//required object type
		
		Actor[] actors=mapper1.readValue(jsonBody1, 				//body
																			Actor[].class);	//required type
		List<Actor> actorsList=Arrays.asList(actors);
		
		System.out.println("Response body as the List<Actor> object's data: "+actorsList);
		System.out.println("------------------");
		actorsList.forEach(System.out::println);
		System.out.println("------------------");
		
		List<Actor> actorsList1=mapper1.readValue(jsonBody1,new TypeReference<List<Actor>>() {});
		actorsList.forEach(System.out::println);
		System.out.println("------------------");
		
	}
}
