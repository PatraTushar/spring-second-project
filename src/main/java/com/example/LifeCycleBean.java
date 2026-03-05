package com.example;

import com.loose.NotificationService;

public class LifeCycleBean {

    private NotificationService notificationService;

    // ---------------------------------------------------
    // STEP 1 :
    // Constructor is called by Spring when bean is created
    //
    // This happens inside @Bean method
    // After dependency injection
    // ---------------------------------------------------
    public LifeCycleBean(NotificationService notificationService) {

        System.out.println("Constructor Called - Dependency Injected");

        this.notificationService = notificationService;
    }

    // ---------------------------------------------------
    // STEP 2 :
    // After constructor finishes,
    // Spring calls initMethod automatically
    //
    // Because we wrote:
    // @Bean(initMethod="init")
    // ---------------------------------------------------
    public void init() {

        System.out.println("init() called - Bean Initialized");

        notificationService.send("Hello from init()");
    }

    // ---------------------------------------------------
    // STEP 3 :
    // Application manually calls this method
    // ---------------------------------------------------
    public void performTask() {

        System.out.println("Bean is Ready for Use");
    }

    // ---------------------------------------------------
    // STEP 4 :
    // When container is closed,
    // Spring calls destroyMethod automatically
    //
    // Because we wrote:
    // destroyMethod="cleanUp"
    // ---------------------------------------------------
    public void cleanUp() {

        System.out.println("cleanUp() called - Bean Destroyed");
    }
}