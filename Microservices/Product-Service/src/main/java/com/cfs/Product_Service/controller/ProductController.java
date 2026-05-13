package com.cfs.Product_Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private Environment env;
    
    @GetMapping("/place")
    public String placeOrder()
    {
        String port = env.getProperty("server.port");
        return "Running on port "+ port +" Hello you order : Iphone is placed";
    }

    @GetMapping("/product/{name}")
    public String orderWithName(@PathVariable String name)
    {
        return "Hello " + name + "Your order";
    }
}
