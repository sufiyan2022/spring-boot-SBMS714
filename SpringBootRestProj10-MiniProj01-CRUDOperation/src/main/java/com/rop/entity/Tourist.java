package com.rop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Tourist_REST")
public class Tourist implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  //hibernate_sequence will be created automatically
	private Integer tid;
	
	@Column(length=20)
	@NonNull
	private String name;
	
	@Column(length=20)
	@NonNull
	private String city;
	
	@Column(length=20)
	@NonNull
	private String packageType;
	
	//@Column(length=20)// length is working only String type
	@NonNull
	private Double budget;
	
	
}
