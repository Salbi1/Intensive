package com.example.block3.controller;

import com.example.block3.service.MyTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppController {
    private final MyTestService myTestService;

    @GetMapping
    public String testControl() {
        myTestService.method(3);
        return "Hello world";
    }
}
