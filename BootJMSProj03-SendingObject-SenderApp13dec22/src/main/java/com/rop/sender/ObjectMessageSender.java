package com.rop.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rop.model.ActorInfo;

@Component
public class ObjectMessageSender {

	@Autowired
	private JmsTemplate template;
	
	@Scheduled(cron="0/20 * * * * *")
	public void sendObjectDataAsMsg() {
//		prepare object
		ActorInfo actor=new ActorInfo(1001, "ranveer", "mumbai");
//		send object as the message
		template.convertAndSend("obj_mq1",actor);
		System.out.println("Object is sent as Message ");
		
	}
}
