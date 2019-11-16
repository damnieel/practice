package com.cvc.springboot.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	@GetMapping("/sendMap")
	public void sendMap() {
		Map map = new HashMap<String,String>();
		map.put("mobile", "16675558877");
		map.put("content", "牛批");
		jmsMessagingTemplate.convertAndSend("map",map);
	}
}
