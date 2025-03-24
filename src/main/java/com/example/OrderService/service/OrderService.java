package com.example.OrderService.service;

import com.example.OrderService.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void message(OrderEntity orderEntity) {
        kafkaTemplate.send("myTopic", orderEntity.toString());
    }
}
