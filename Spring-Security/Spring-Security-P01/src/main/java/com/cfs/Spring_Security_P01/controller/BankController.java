package com.cfs.Spring_Security_P01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    int balance = 1000;

    @GetMapping("/balance")
    public int getBalance()
    {
        return balance;
    }

    @PostMapping("/update")
    public int updateBalance(@RequestParam String AcctNo, @RequestParam int newBalance)
    {
        return balance + newBalance;
    }
}
