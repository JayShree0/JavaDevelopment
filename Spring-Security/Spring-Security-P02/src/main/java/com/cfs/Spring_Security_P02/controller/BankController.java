package com.cfs.Spring_Security_P02.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @GetMapping("/contactUs")
    public String contactUs()
    {
        return "Contact us at : 9876543212";
    }

    @GetMapping("/transfer")
    public String transfer()
    {
        return "your money transfer successfully";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "Welcome admin!";
    }

    @GetMapping("/about")
    public String about()
    {
        return "Jay Shree founder of Jay's Bank";
    }
}
