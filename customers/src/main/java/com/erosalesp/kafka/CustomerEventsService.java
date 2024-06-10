package com.erosalesp.kafka;

import com.erosalesp.kafka.events.CustomerCreatedEvent;
import com.erosalesp.kafka.events.Event;
import com.erosalesp.kafka.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.erosalesp.entity.Customer;

import java.util.Date;
import java.util.UUID;

@Component
public class CustomerEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	public void publish(Customer customer) {

		CustomerCreatedEvent created = new CustomerCreatedEvent();
		created.setData(customer);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send("customer-topic", created);
	}

}
