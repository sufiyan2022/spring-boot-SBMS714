package com.rop.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

	@JmsListener(destination="testMq1")
	public void readMessage(String text) {
		System.out.println("Received Message is :"+ text);
	}
}
