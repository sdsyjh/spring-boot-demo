package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
	
	@KafkaListener(topics="test")
	public void onMessage(String message) {
		System.out.println(message);
	}
}