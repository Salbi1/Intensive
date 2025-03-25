package com.example.Feign.controller;

import com.example.Feign.feign.CustomFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final CustomFeign customFeign;

    @GetMapping("/call-other-service")
    public String callOtherService() {
        return customFeign.callOtherService();
    }
}
