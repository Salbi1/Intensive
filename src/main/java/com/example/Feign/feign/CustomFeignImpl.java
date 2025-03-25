package com.example.Feign.feign;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CustomFeignImpl implements CustomFeign {
    @Override
    public String callOtherService() {
        log.info("ddddd");
        return "Отвалился брат";
    }
}
