package com.erosalesp.kafka.service;

import com.erosalesp.kafka.events.CustomerCreatedEvent;
import com.erosalesp.kafka.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerEventsService {

	@KafkaListener(
			topics = "customer-topic",
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo-customer")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(CustomerCreatedEvent.class)) {
			CustomerCreatedEvent customerCreatedEvent = (CustomerCreatedEvent) event;
			log.info("Received Customer created event .... with Id={}, data={}",
					customerCreatedEvent.getId(),
					customerCreatedEvent.getData().toString());
		}

	}
	
	

}
