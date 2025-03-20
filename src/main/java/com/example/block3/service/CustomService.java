package com.example.block3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomService {
    private final MyTestService myTestService;

    public int getMethod() {
        return myTestService.method();
    }
}
