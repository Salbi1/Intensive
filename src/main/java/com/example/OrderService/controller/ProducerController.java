package com.example.OrderService.controller;

import com.example.OrderService.entity.OrderEntity;
import com.example.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create-order")
@RequiredArgsConstructor
public class ProducerController {
    private final OrderService orderService;

    @PostMapping
    public String postMessage(@RequestBody OrderEntity orderEntity) {
        orderService.message(orderEntity);
        return "Order send to Kafka: " + orderEntity.getOrderId();
    }
}
