package com.rop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms    //optional to write
public class BootJmsProj01ReceiverApp13dec221Application {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj01ReceiverApp13dec221Application.class, args);
	}

}
