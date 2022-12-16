package com.rop.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageSubscriber {

	@JmsListener(destination="topic1")
	public void readMessage(String text) {
		System.out.println("Received Message is :"+ text);
	}
}
