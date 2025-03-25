package com.example.Feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service", fallback = CustomFeignImpl.class)
public interface CustomFeign {
    @GetMapping("/call-other-service")
    String callOtherService();
}
