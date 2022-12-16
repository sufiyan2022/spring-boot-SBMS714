package com.rop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJms
public class BootJmsProj03SendingObjectSenderApp13dec22Application {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj03SendingObjectSenderApp13dec22Application.class, args);
	}

}
