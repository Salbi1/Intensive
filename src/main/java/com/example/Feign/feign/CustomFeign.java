package com.example.Feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "other-service")
public interface CustomFeign {

    @GetMapping("/other-service-endpoint")
    String callOtherService();
}
