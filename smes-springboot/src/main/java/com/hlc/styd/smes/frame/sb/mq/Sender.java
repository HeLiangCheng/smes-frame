package com.hlc.styd.smes.frame.sb.mq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
  
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(){
		String context="study springboot mq"+new Date();
		System.out.println("Sender:"+context);
		this.rabbitTemplate.convertAndSend("smesmq",context);
	}

}
