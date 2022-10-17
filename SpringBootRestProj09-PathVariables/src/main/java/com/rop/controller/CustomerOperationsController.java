package com.rop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {

	
	/*
	 * experiment 1
	 */
//	@GetMapping("/report/{no}/{name}")
//	public String fetchData2(@PathVariable(name="name")String cname, @PathVariable(required = false) Integer no){
//		return no+"\t\t"+cname;
//	}
	
	/*
	 * 1 with parameter String,String
	 */
	
//	@GetMapping("/report/{no}/{name}")
//	public String fetchData2(@PathVariable(name="name")String cname, @PathVariable(required = false) String no){//In this both are String
//		return no+"\t\t"+cname;
//	}
	
	//---------------------------------------------------------------------
	
	/*
	 * experiment 2
	 */
	
//	@GetMapping("/report/{no}/{name}")
//	public String fetchData2(@PathVariable(name="name",required=false)String cname, @PathVariable(required = false) Integer no){
//		return no+"\t\t"+cname;
//	}
	
	//------------------------------------------------------------------------
	
	/*
	 * experiment 3
	 */
//	@GetMapping("/report/no/name")
//	public String fetchData1(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
//		System.out.println("from fetchData1");
//		return no+"\t\t"+cname+"\tfrom fetchData1";
//	}
//	
//	@GetMapping("/report/no/{name}")
//	public String fetchData2(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
//		System.out.println("from fetchData2");
//		return no+"\t\t"+cname+"\tfrom fetchData2";
//	}
//	
//	@GetMapping("/report/{no}/{name}")
//	public String fetchData3(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
//		System.out.println("from fetchData3");
//		return no+"\t\t"+cname+"\tfrom fetchData3";
//		
//	}
//	
//	@GetMapping("/report/{no}/name")
//	public String fetchData4(@PathVariable(name="name",required = false)String cname, @PathVariable(required = false) Integer no){
//		System.out.println("from fetchData4");
//		return no+"\t\t"+cname+"\tfrom fetchData4";
//	}
	
	//----------------------------------------------------
	
	/*
	 * experiment 4
	 */
	
	@GetMapping("/report/101/raja")
	public String fetchData1(){
		System.out.println("from fetchData1");
		return "from fetchData1";
	}
	
	@GetMapping("/report/{no}/{name}")
	public String fetchData2(@PathVariable(name="name")String cname, @PathVariable Integer no){
		System.out.println("from fetchData2");
		return "from fetchData2";
	}
	
	//------------------------------------------------------------------------
	
	/*
	 * experiment 5
	 * if we take two method with same request path then we well get illegalStateException.
	 */
	
	
	
}
