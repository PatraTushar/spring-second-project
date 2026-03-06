package com.example;

import org.springframework.stereotype.Component;

/*
===============================================================
STEP 6

During @ComponentScan Spring finds this class.

@Component("myBean") tells Spring:

Create an object of this class and store it
inside the IoC container.

Bean Name → myBean
Bean Type → GreetingService
===============================================================
*/
@Component("myBean")
public class GreetingService {

    public void sayHello() {

        System.out.println("Hello From Spring!");

    }
}