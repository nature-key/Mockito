package com.example.mockito.service;

import org.springframework.stereotype.Service;

@Service
public class Less03Service {

    public Less03 get(){
        throw  new RuntimeException();
    }
}
