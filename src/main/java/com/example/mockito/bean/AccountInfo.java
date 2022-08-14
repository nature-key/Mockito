package com.example.mockito.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountInfo {

    private String userName;

    private String passWord;
}
