package com.cvc.springboot.domain.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@JmsListener(destination="practice")
	public void readMessage(String text) {
		System.out.println(text);
	}
}
