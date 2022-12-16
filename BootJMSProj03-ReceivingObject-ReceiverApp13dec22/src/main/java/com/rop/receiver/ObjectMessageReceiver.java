package com.rop.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.rop.model.ActorInfo;

@Component
public class ObjectMessageReceiver {


	@JmsListener(destination="obj_mq1")
	public void consumeObjectDataAsMsg(ActorInfo actor) {
		System.out.println("Received Object Data ::"+actor);
		
	}
}
