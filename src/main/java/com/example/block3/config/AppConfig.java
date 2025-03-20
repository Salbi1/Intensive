package com.example.block3.config;

import com.example.block3.customScope.CustomScope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomScope customScope() {
        return new CustomScope();
    }

    public CustomScopeConfigurer customScopeConfigurer(CustomScope customScope,
                                                       ConfigurableBeanFactory beanFactory) {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("MyCustom", customScope);
        return configurer;
    }
}
