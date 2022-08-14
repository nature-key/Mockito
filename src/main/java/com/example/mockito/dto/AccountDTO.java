package com.example.mockito.dto;

import com.example.mockito.bean.AccountInfo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class AccountDTO {

    public AccountInfo login(String userName, String passWord) throws Exception {
        if (!StringUtils.isEmpty(userName) || !StringUtils.isEmpty(passWord)) {
            throw new Exception();
        }
        return AccountInfo.builder()
                .userName("wangXuan")
                .passWord("jiePi")
                .build();
    }

}
