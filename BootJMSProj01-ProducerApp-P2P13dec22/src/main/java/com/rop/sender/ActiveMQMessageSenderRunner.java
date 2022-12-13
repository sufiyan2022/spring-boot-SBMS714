package com.rop.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageSenderRunner implements CommandLineRunner {
	
	@Autowired
	private JmsTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
//		using annonomyous inner calss logics
//		template.send("testMq1", new MessageCreator() {
//			
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//			Message message=session.createTextMessage("From Sender at:: "+new Date());
//				return message;
//			}
//		});
		
//		using Lambda style annonymous inner class
//		template.send("testMq1",ses->{
//			return ses.createTextMessage("Fro sender at "+new Date());
//		});
		
		template.send("testMq1",ses->ses.createTextMessage("From sender at "+new Date()));
		System.out.println("Message sent.");
	}

}
