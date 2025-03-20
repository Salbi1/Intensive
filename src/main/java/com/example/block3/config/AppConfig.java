package com.example.block3.config;

import com.example.block3.CustomHeaderInterceptor;
import com.example.block3.customScope.CustomScope;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class AppConfig implements WebMvcConfigurer {
    private final CustomHeaderInterceptor customHeaderInterceptor;

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customHeaderInterceptor).addPathPatterns("/**");
    }
}
