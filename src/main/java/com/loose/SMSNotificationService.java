package com.loose;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//  Step 2 (Continued):
// Spring finds this class too
//  It creates object automatically
// 👉Stores it in IoC container
//  Bean id = "smsNotificationService" (default class name small letter)
@Primary
public class SMSNotificationService implements NotificationService {


    @Override
    public void send(String message) {

        //  Step 7:
        // When notifyUser() calls this method
        // This method executes

        System.out.println(" SMS :  " + message);


    }
}
