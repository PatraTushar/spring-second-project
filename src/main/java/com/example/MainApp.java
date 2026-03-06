package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // ======================================================
        // STEP 1
        // JVM starts execution from main() method
        // ======================================================

        System.out.println("Starting Spring Application Context");


        // ======================================================
        // STEP 2
        // Creating the Spring IoC Container
        //
        // This is the MOST important step.
        // When this line runs, Spring starts container initialization.

        //Spring initialization mainly means Spring starts the container, processes configuration/annotations, and creates & stores beans inside the IoC container.
        // ======================================================

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        // ======================================================
        // STEP 3
        // During container creation Spring does internally:
        //
        // 1. Reads AppConfig class
        // 2. Processes @Configuration
        // 3. Processes @ComponentScan
        // 4. Finds components like GreetingService
        // 5. Processes @Bean methods
        // 6. Creates beans
        // 7. Injects dependencies
        // 8. Calls init methods
        //
        // After all beans are ready, control returns to main().
        // ======================================================


        System.out.println("Retrieving Lifecycle Bean");


        // ======================================================
        // STEP 4
        // Requesting a bean from the IoC container
        //
        // Spring searches inside container and returns
        // the already created LifeCycleBean object.
        // ======================================================

        LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);


        // ======================================================
        // STEP 5
        // Application uses the bean
        // This is normal method execution.
        // ======================================================

        lifeCycleBean.performTask();


        System.out.println("Closing Spring Context");


        // ======================================================
        // STEP 6
        // Destroy method runs ONLY when container is closed.
        //
        // Example:
        // ((AnnotationConfigApplicationContext) context).close();
        //
        // Then Spring will call cleanUp().
        // ======================================================
    }
}