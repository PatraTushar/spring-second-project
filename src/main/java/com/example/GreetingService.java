package com.example;

import org.springframework.stereotype.Component;

// Step 1: This class is marked as a Spring Bean
// Because of @Component
//Spring creates the object, assigns a bean ID, and stores both the ID and object inside the IoC container.
//"myBean"  →  GreetingService object
@Component("myBean")  // Bean name = "myBean"
public class GreetingService {

    public void sayHello() {

        System.out.println(" Hello From Spring! ");
    }
}