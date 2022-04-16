package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
//@Table(name="CORONA_VACCINE_TAB")  //optional if you want to take db table name same as Entity class name
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CoronaVaccine {

	@Id
	@Column(name="regNo")  //optional if you want to take property name as column name 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String company;
	@Column(length=20)
	private String contory;
	private Double price;
	private Integer reqDoseCount;
}
