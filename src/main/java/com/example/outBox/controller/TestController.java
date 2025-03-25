package com.example.outBox.controller;

import com.example.outBox.service.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {
    private final SendMessage sendMessage;

    @PostMapping
    public void setMessage(@RequestBody String text) {
        sendMessage.message(text);
    }
}
