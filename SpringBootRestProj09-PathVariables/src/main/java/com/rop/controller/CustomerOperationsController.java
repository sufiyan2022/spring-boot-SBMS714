package com.rop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {

//	@PostMapping("/report/{no}/{name}")
//	public String fetchData2(@PathVariable(name="name")String cname, @PathVariable(required = false) Integer no){
//		return cname+"\t\t"+no;
//	}
	
//	@PostMapping("/report/{no}/{name}")
//	public String fetchData2(@PathVariable(name="name")String cname, @PathVariable(required = false) String no){//In this both are String
//		return cname+"\t\t"+no;
//	}
	
	//---------------------------------------------------------------------
	
//	@PostMapping("/report/{no}/{name}")
//	public String fetchData2(@PathVariable(name="name",required=false)String cname, @PathVariable(required = false) Integer no){
//		return cname+"\t\t"+no;
//	}
	
	//------------------------------------------------------------------------
	
	@GetMapping("/report/no/name")
	public String fetchData1(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
		System.out.println("from fetchData1");
		return cname+"\t\t"+no;
	}
	
	@GetMapping("/report/no/{name}")
	public String fetchData2(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
		System.out.println("from fetchData2");
		return cname+"\t\t"+no;
	}
	
	@GetMapping("/report/{no}/{name}")
	public String fetchData3(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
		System.out.println("from fetchData3");
		return cname+"\t\t"+no;
	}
	
	@GetMapping("/report/{no}/name")
	public String fetchData4(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
		System.out.println("from fetchData4");
		return cname+"\t\t"+no;
	}
	
}
