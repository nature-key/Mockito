package com.example.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class Less03ServiceTest {

//    @Mock
//    private Less03Service less03Service;
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Less03Service less03Service;

//    @Mock
//    private Less03 less03;



    @BeforeEach
    private   void  init(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void test() {
//        Mockito.when(less03Service.get()).thenReturn(less03);
//        Less03 less03 = less03Service.get();
////        less03.foo();
//        String foo = less03.foo();

        String foo = less03Service.get().foo();
    }
}