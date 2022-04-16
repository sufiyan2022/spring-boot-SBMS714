package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.Employee;

@SpringBootApplication
public class BootProj08InjectingValuesAllTypesOfSpringBeanPropertiesApplicationYAML {

	public static void main(String[] args) {
		// get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj08InjectingValuesAllTypesOfSpringBeanPropertiesApplicationYAML.class, args);
		
		//get Spring Bean object
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		
//		close Container object
		((ConfigurableApplicationContext) ctx).close();
	}

}
