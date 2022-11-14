package com.rop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMsProj02EurekaServer29OctApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsProj02EurekaServer29OctApplication.class, args);
	}

}
