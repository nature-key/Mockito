package com.example.mockito.controller;


import com.example.mockito.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public String login(@RequestParam String userName,
                        @RequestParam String passWord) {
        return accountService.login(userName, passWord);
    }
}
