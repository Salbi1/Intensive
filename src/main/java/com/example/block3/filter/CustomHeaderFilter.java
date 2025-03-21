package com.example.block3.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@WebFilter("/*")
public class CustomHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        CustomHttpServeletRequestWrapper wrappedRequest =
                new CustomHttpServeletRequestWrapper(httpServletRequest);

        wrappedRequest.setHeader("X-Custom-Header", "header custom");
        chain.doFilter(httpServletRequest, httpServletResponse);
    }
}
