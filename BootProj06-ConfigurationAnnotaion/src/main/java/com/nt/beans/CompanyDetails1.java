package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("company1")
@Data

//@ConfigurationProperties(prefix="org.nit") //only one place it work
public class CompanyDetails1 {

	@Value("${org.nit.name}")
	private String title;
	@Value("${org.nit.type}")
	private String type;
	@Value("${org.nit.location}")
	private String addrs;
	
//	@Override
//	public String toString() {
//		return "CompanyDetails1 [title=" + title + ", type=" + type + ", addrs=" + addrs + "]";
//	}
	
	
}
