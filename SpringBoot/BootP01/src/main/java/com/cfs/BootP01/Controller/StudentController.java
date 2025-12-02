package com.cfs.BootP01.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/welcome")
    public String welcome()
    {
        return "Hello sir welcome";
    }
}
