package com.cfs.Notification_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NotificationController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductAPI productAPI;

    @GetMapping("/notification")
    public String Notification()
    {
        return "Email sent to user";
    }

  /*
    @GetMapping("/notification/product")
    public String getProduct()
    {
        String s1 = "Hello from notification API..";
        String s2 = restTemplate.getForObject("http://localhost:9091/place", String.class);
        return s1 + " " + s2;
    }

   */

    @GetMapping("/notification/product")
    public String getProduct()
    {
        String s1 = "Hello from notification API..";
        String s2 = productAPI.invokeProductAPI();
        return s1 + "[ Product API ] " + s2;
    }
}
