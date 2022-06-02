package com.rop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rop.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {

//	@GetMapping("/wish")
//	public ResponseEntity<String> displayWishMessage(){
//		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
//	}
	
//	@GetMapping("/wish/{id}/{name}")
//	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id,
//																								@PathVariable String name){
//		return new ResponseEntity<String>("Good Morning::"+id+"........."+name,HttpStatus.OK);
//	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>("Actor Data : "+actor.toString(),HttpStatus.OK);
	}
	
}
