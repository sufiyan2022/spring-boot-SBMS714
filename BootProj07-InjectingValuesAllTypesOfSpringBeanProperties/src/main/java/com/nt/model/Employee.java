package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix="emp.info")
public class Employee {

	private String name;
	private long id;
	private String[] nickName;
	private List<String> teamMember;
	private Set<Long> phoneNumbers;
	private Map<String,Object> idDetails;
	private Company compDetails;
}
