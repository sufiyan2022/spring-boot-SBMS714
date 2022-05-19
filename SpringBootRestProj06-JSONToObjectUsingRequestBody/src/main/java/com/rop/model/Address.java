package com.rop.model;

import lombok.Data;

@Data
public class Address {

	private String houseNo;
	private String streetName;
	private String loc;
	private Long pinCode;
}