package com.rop.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rop.entity.Tourist;

/*
 * while develop or running this take Proj11 and this bcoz Proj11 is provider/server/producer app.
 *  and this Lab15 is spring mvc client app.
 */


@Controller
public class TouristOperationsController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/")
	public String showHome() {
		return "home";  //logical view name. LVN
	}
	
	@GetMapping("/list_tourists")
	public String displayTouristReport(Map<String,Object> map) throws Exception{
		/*
		 * 
		 * 		Consume Spring Rest service/method/operation
		url/uri: http://localhost:4040/RestMiniProjectException/tourist/findAll
		method: GET
		response content type: Application/json (default)(no need to set)
		no path variables/no query String
		no headers, body required
		String serviceUrl="http://localhost:4040/RestMiniProjectException/tourist/findAll";
		 */
		
		String serviceUrl="http://localhost:9999/SpringBootRestProj11-MiniProj-ExceptionHandler/tourist/findAll";
		ResponseEntity<String> resp=template.exchange(serviceUrl, 
																									HttpMethod.GET,
																									null,  //no body
																									String.class); 
		String jsonRespBody=resp.getBody();
//		convert String json resp body to List<Tourist> java object (List of Model object)
		ObjectMapper mapper=new ObjectMapper();
		List<Tourist> touristList=mapper.readValue( jsonRespBody, new TypeReference<List<Tourist>>(){}) ;
//		keep result in Map collection as ModelAttribute
		map.put("touristList", touristList);
//		return Logical view name (LVN)
		return "tourist_report";
	}
	
	@GetMapping("/addz") //To Launch form page
	public String showRegisterTouristForm(@ModelAttribute("tst") Tourist tourist) {// here data binding is happening is argument
		return "add_tourist";
	}
	
	@PostMapping("/addz")
//	public String registerTourist(Map<String,Object> map,@ModelAttribute("tst") Tourist tourist)throws Exception {
	public String registerTourist(RedirectAttributes attr,@ModelAttribute("tst") Tourist tourist)throws Exception {
		 
//		Convert object to json data using jackson api
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writeValueAsString(tourist);
		
//		invoke spring rest service
		
		String serviceUrl="http://localhost:9999/SpringBootRestProj11-MiniProj-ExceptionHandler/tourist/register";
		
		
//		prepare HttpEntity object(headers+body) //actuall this is optional sir told check this
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity=new HttpEntity<String>(jsonData, headers);
		ResponseEntity<String> resp=template.exchange(serviceUrl, 
																										HttpMethod.POST, 
																										entity, 
																										String.class);
		
//		get json body from response of another server
		String result=resp.getBody();
//		map.put("resultMsg",result); //if we will keep msg in this manner it will not go to page, use next statement
		attr.addFlashAttribute("resultMsg", result); //keep parameter as RedirectAttributes attr, then call attr.addFlashAttribute("resultMsg", result) then it will go
		return "redirect:list_tourists";
	}
	
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("id")Integer mid, @ModelAttribute ("tst")Tourist tourist)throws Exception {
//		invoke spring rest service
		String serviceUrl="http://localhost:9999/SpringBootRestProj11-MiniProj-ExceptionHandler/tourist/find/{id}";
		
//		GET mode request no body to send. directly exchange method call.
		
		ResponseEntity<String> resp=template.exchange(serviceUrl, 
				HttpMethod.GET, 
				null, 
				String.class,
				mid);
		
//		get json body from response
		String jsonBody=resp.getBody();
//		convert json body to Tourist object using Object Mapper.
		ObjectMapper mapper=new ObjectMapper();
		Tourist tourist1=mapper.readValue(jsonBody, Tourist.class);
		BeanUtils.copyProperties(tourist1, tourist);
		return "edit_tourist";
	}
	
	@PostMapping("/edit")
	public String editTourist(RedirectAttributes attributes, @ModelAttribute("tst") Tourist tourist)throws Exception{
		
//		convert object to JSON data using jackson api
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writeValueAsString(tourist);
		
//		invoke spring rest service
		String serviceUrl="http://localhost:9999/SpringBootRestProj11-MiniProj-ExceptionHandler/tourist/modify";
		
//		prepare HttpEntity object (headers+body)
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity=new HttpEntity<String>(jsonData, headers);
		
//		template.put(serviceUrl, entity); // dont use bcoz put() return type is void we could not get the result msg
		
		ResponseEntity<String> resp=template.exchange(serviceUrl, 
																										HttpMethod.PUT, 
																										entity, 
																										String.class);
				
//		get json body from response 
		String result=resp.getBody();

		attributes.addFlashAttribute("resultMsg", result);
		return "redirect:list_tourists";
	}
	
	@GetMapping("/delete")
	public String deleteTourist(@RequestParam("id") Integer id,RedirectAttributes attr) {
		
//		invoke spring rest service
		String serviceUrl="http://localhost:9999/SpringBootRestProj11-MiniProj-ExceptionHandler/tourist/delete/{id}";
		
		ResponseEntity<String> resp=template.exchange(serviceUrl, 
				HttpMethod.DELETE, 
				null, 
				String.class,
				id);
		
		String result=resp.getBody();
		attr.addFlashAttribute( "resultMsg",result);
		return "redirect:list_tourists";
	}
}
