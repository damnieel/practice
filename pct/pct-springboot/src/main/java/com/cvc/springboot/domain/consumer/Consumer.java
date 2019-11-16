package com.cvc.springboot.domain.consumer;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@JmsListener(destination="practice")
	public void readMessage(String text) {
		System.out.println(text);
	}
	
	@JmsListener(destination="map")
	public void readMap(Map map) {
		System.out.println(map);
	}
}
