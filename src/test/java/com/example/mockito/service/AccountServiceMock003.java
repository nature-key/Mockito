package com.example.mockito.service;

import com.example.mockito.bean.AccountInfo;
import com.example.mockito.dto.AccountDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class AccountServiceMock003 {


    //     MockitoJUnit.rule()
//    @Rule
//    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountDTO accountDTO;


    @Test
    public   void  test() throws  Exception{

        AccountInfo login = accountDTO.login("x", "x");
        System.out.println(login);


    }

}
