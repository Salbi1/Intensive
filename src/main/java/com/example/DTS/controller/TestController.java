package com.example.DTS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/auth/")
    public String registr() {
        return "Hello world!";
    }
}
