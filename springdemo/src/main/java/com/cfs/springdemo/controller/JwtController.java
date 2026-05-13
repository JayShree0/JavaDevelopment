package com.cfs.springdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class JwtController {

    @PostMapping("/generate-Token")
    public String generateToken(@RequestParam String username, @RequestParam String password)
    {
        if("admin".equals(username) && "admin".equals(password))
        {
            // generate jwt
            return jwt
        }
    }
}
