package com.example.InventoryService.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
//    @PostMapping
//    @KafkaListener(topics = "myTopic", groupId = "my-consumer")
//    public String getMessage(@Payload String message) {
//        System.out.println(message);
//        return message;
//    }
}
