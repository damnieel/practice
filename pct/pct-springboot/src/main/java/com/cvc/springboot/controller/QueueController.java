package com.cvc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@GetMapping("/send")
	public void send(String message) {
		jmsMessagingTemplate.convertAndSend("practice",message);
	}
}
