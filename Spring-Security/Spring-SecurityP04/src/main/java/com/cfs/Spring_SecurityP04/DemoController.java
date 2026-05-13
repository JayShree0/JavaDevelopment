package com.cfs.Spring_SecurityP04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private UserService service;

    // This is public method
    @PostMapping("/addUsers")
    public String addUsers(@RequestBody UserListRequest request)
    {
        service.saveUsers(request.getUsers());
        return "User saved successfully";
    }

    // This is public method
    @GetMapping("/public")
    public String publicMethod()
    {
        System.out.println("public method called");
        return "This is public method";
    }

    // hasRole('ADMIN') -> can only access this method
    @GetMapping("/admin")
    public String adminMethod()
    {
        System.out.println("admin method called");
        return "This is admin method";
    }

/*
    // hasRole('USER') -> can only access this method
    @GetMapping("/user")
    public String userMethod()
    {
        return "This is user method";
    }


 */
}
