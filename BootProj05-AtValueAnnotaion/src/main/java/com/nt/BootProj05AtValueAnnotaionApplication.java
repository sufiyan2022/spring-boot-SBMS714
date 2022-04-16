package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.BillGenerator;

@SpringBootApplication
public class BootProj05AtValueAnnotaionApplication {

	public static void main(String[] args) {
//		get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj05AtValueAnnotaionApplication.class, args);
		

//		get Spring bean class object
		BillGenerator generator=ctx.getBean("bill",BillGenerator.class);
		System.out.println("data :"+generator);
		
//		close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
