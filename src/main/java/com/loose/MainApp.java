package com.loose;


import com.example.LifeCycleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {

    public static void main(String[] args) {

        //  Step 1: Spring Container Starts Here

     ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       // UserService userService = (UserService) context.getBean("UserServiceSMS");
      UserService userService = (UserService) context.getBean(UserService.class);

      userService.notifyUser(" Whats up! ");









    }
}
