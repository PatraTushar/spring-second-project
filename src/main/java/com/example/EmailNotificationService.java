package com.example;



import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {

        System.out.println(" Email : "+message);
    }
}
