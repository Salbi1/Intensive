package com.example.InventoryService.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerKafka {
    @KafkaListener(topics = "myTopic", groupId = "group1")
    public void listen(@Payload String message) {
        System.err.println(message);
    }
}
