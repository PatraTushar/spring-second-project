package com.example;

import com.loose.NotificationService;

public class LifeCycleBean {

    private NotificationService notificationService;

    /*
    ===============================================================
    STEP 9 (Triggered from AppConfig @Bean method)

    When Spring executes:

    return new LifeCycleBean(notificationService);

    The constructor runs.

    Dependency has already been injected by Spring.
    ===============================================================
    */
    public LifeCycleBean(NotificationService notificationService) {

        System.out.println("Constructor Called - Dependency Injected");

        this.notificationService = notificationService;
    }


    /*
    ===============================================================
    STEP 10

    After bean creation,
    Spring automatically calls init()

    Because we configured:

    @Bean(initMethod="init")

    This happens during container initialization.
    ===============================================================
    */
    public void init() {

        System.out.println("init() called - Bean Initialized");

        notificationService.send("Hello from init()");
    }


    /*
    ===============================================================
    STEP 11

    This method is called manually by the application
    from MainApp.
    ===============================================================
    */
    public void performTask() {

        System.out.println("Bean is Ready for Use");
    }


    /*
    ===============================================================
    STEP 12

    When Spring container shuts down,
    Spring automatically calls this method.

    Because we configured:

    destroyMethod="cleanUp"
    ===============================================================
    */
    public void cleanUp() {

        System.out.println("cleanUp() called - Bean Destroyed");
    }
}