package com.example.block3.config;

import com.example.block3.customScope.CustomScope;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public CustomScope customScope() {
        return new CustomScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(CustomScope customScope,
                                                       ConfigurableBeanFactory beanFactory) {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("MyCustom", customScope);
        return configurer;
    }
}
