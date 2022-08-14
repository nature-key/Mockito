package com.example.mockito.service;


import com.example.mockito.bean.AccountInfo;
import com.example.mockito.dto.AccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class AccountService {


    @Autowired
    private AccountDTO accountDTO;

    public String login(String userName, String passWord) {

        try {
            AccountInfo login = accountDTO.login(userName, passWord);
            if (Objects.isNull(login)) {
                return "404";
            }
            return "500";
        } catch (Exception e) {
            log.error("login error:{}", e.getMessage());
        }
        return "error";
    }


}
