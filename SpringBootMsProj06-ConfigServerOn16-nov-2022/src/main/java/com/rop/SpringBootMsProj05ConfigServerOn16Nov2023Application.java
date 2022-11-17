package com.rop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootMsProj05ConfigServerOn16Nov2023Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsProj05ConfigServerOn16Nov2023Application.class, args);
	}

}
