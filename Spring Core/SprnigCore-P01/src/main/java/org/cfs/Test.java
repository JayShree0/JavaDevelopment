package org.cfs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        System.out.println("----------Bean Factory Started-------");
        // Jaise he IOC container start hota hai wo bean file read krke object bna deta hai jitne bhi definitation de hai..
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("-------Bean File Loaded------");


        System.out.println("Sending request.....[constructor ise pehla chlla to eager loading else lazy loading");
        Car car = context.getBean(Car.class);
        car.drive();
    }
}
