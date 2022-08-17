package com.example.mockito.service;

import com.example.mockito.dto.AccountDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AccountServiceMock002 {


    @BeforeAll
    private void  init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private AccountDTO accountDTO;

    @Test
    public void  test()throws Exception{
        accountDTO.login("x","x");
    }
}
