package com.example.block3.customScope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import java.util.HashMap;
import java.util.Map;

public class CustomScope implements Scope {
    Map<String, Object> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return map.computeIfAbsent(name, n -> objectFactory.getObject());
    }

    @Override
    public Object remove(String name) {
        return map.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "MyCustom";
    }
}
