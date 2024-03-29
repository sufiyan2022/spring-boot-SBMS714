package com.rop.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController //(@Controller and @ResponseBody on all the handler methods)
@Controller
@RequestMapping("/message") //Global path (purely optional)
public class MessageRenderController {

	@GetMapping("/generate")
//	@ResponseBody //if we will not use @ResponseBody then also work with @Controller bcoz return type is ResponseEntity<String>
	public ResponseEntity<String> generateMessage(){
		
//		get System data and time
		LocalDateTime ldt=LocalDateTime.now();
//		get current hour of the day
		int hour=ldt.getHour();
		String body=null;
		if(hour<12)
			body="Good Morning!!!";
			else if(hour<16)
				body="Good AfterNoon!!!";
				else if(hour<20)
					body="Good Evening!!!";
				else
					body="Good Night!!!";
//		Response Status
		
		HttpStatus status=HttpStatus.OK;
		
//		Create ResponseEntityObject
		ResponseEntity<String> entity=new ResponseEntity<String>(body, status);
		return entity;			
	}
}
