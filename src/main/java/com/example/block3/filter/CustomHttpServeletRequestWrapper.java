package com.example.block3.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

public class CustomHttpServeletRequestWrapper extends HttpServletRequestWrapper {
    private final Map<String, String> customHeaders = new HashMap<>();

    public CustomHttpServeletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public void setHeader(String name, String value) {
        customHeaders.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        if(customHeaders.containsKey(name)) {
            return customHeaders.get(name);
        }
        return super.getHeader(name);
    }
}
