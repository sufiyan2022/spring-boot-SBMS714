package com.rop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMsProj05EurekaServerOn16Nov2022Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsProj05EurekaServerOn16Nov2022Application.class, args);
	}

}
