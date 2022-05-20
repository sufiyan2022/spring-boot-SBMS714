package com.rop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rop.entity.Tourist;
import com.rop.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	
	@Autowired
	private ITouristMgmtService touristService;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		try {
//			use service
			String resultMsg=touristService.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED); //201 content created successfully
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in Tourist Enrollment", HttpStatus.INTERNAL_SERVER_ERROR); //500 error
		}
		
	}
}
