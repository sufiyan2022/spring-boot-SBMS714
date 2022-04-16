package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.Employee;

@SpringBootApplication
public class BootProj07InjectingValuesAllTypesOfSpringBeanPropertiesApplication {

	public static void main(String[] args) {
		// get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj07InjectingValuesAllTypesOfSpringBeanPropertiesApplication.class, args);
		
		//get Spring Bean object
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		
//		close Container object
		((ConfigurableApplicationContext) ctx).close();
	}

}
