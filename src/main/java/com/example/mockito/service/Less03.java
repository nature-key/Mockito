package com.example.mockito.service;

import org.springframework.stereotype.Component;

@Component
public class Less03 {

    public String foo() {
        throw new RuntimeException();
    }
}
