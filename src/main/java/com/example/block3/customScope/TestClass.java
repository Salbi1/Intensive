package com.example.block3.customScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("MyCustom")
public class TestClass {
}
