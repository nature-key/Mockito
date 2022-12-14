package com.example.mockito.service;


import com.example.mockito.bean.AccountInfo;
import com.example.mockito.dto.AccountDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
//@ExtendWith(MockitoJUnitRunner.class)
class AccountServiceTest {


    @Mock
    private AccountDTO accountDTO;

    @InjectMocks
    private AccountService accountService;


    @Test
    public void login() throws Exception {
        AccountInfo accountInfo = Mockito.mock(AccountInfo.class, Answers.RETURNS_SMART_NULLS);
//        Mockito.when(accountDTO.login(Mockito.anyString(), Mockito.anyString())).thenReturn(accountInfo);
////        Mockito.when(accountService.login(Mockito.anyString(), Mockito.anyString())).thenReturn("successful");
//        String login = accountService.login("wanxuan", "jiepi");
//        Assertions.assertEquals(login, "successful");

//        System.out.println(accountInfo);

        Mockito.when(accountDTO.login(Mockito.anyString(),Mockito.anyString())).thenCallRealMethod();

        String login = accountService.login("wangxuan", "jiepi");
        System.out.println(login);
    }

}