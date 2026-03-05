package com.loose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("UserServiceSMS")
//  Step 2: Spring sees this annotation
//  It creates an object of UserService automatically
//  It stores it inside IoC Container with bean id = "UserServiceSMS"
public class UserService {

    //  At this point notificationService is NULL
    // Because object is created first
    public NotificationService notificationService;

    //  Step 3: Spring calls this default constructor
    // When creating the bean
    public UserService() {
    }

    @Autowired
    //  Step 4: Spring sees this constructor
    //  It searches for a bean that implements NotificationService
    //  It finds SMSNotificationService bean
    //  It injects it automatically here
    //UserService.notificationService ->SMSNotificationService object

    //Spring is doing something like this internally:
    //UserService userService =new UserService(smsNotificationServiceObject);


    //for multiple constructor autowired is required because spring doesn't know which constructor to inject
    //but if class has one constructor and you don’t write autowired it is allowed

    public UserService( NotificationService notificationService) {

        //  Step 5: Dependency Injection Happens Here
        // Spring passes SMSNotificationService object
        this.notificationService = notificationService;   // smsNotificationServiceObject
    }


//
//    public UserService(@Qualifier("emailNotificationService") NotificationService notificationService) {
//
//        this.notificationService = notificationService;   // smsNotificationServiceObject
//    }

    public void notifyUser(String message) {

        //  Step 6: When this method runs
        // notificationService is NOT NULL
        // Because Spring already injected SMSNotificationService
        System.out.println(" Hello Spring ");
        notificationService.send(" Notification Hello !!!! ");
    }

    public void setNotificationService(NotificationService notificationService) {

        this.notificationService = notificationService;
    }


}
