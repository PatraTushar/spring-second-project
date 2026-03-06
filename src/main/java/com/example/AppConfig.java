package com.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
========================= ======================================
STEP 4 (Executed During Container Initialization)

Spring reads this class because it was passed to
AnnotationConfigApplicationContext(AppConfig.class)

@Configuration tells Spring:
This class contains bean definitions.
Bean Definition = Metadata (information) about how to create a bean.
===============================================================
*/
@Configuration

/*
===============================================================
STEP 5

Spring processes @ComponentScan.

It scans these packages:

com.example
com.loose

Spring searches for classes with:
@Component
@Service
@Repository
@Controller

If found → Spring creates objects and stores them
inside the IoC container.
===============================================================
*/
@ComponentScan(basePackages = "com.example")
public class AppConfig {


    /*
    ===============================================================
    STEP 7

    Spring sees this @Bean method.

    It registers a bean definition:

    Bean Name      → lifeCycleBean
    Bean Type      → LifeCycleBean
    Init Method    → init()
    Destroy Method → cleanUp()
    Dependency     → NotificationService

    Spring now knows how to create this bean.
    ===============================================================
    */
    @Bean(initMethod = "init", destroyMethod = "cleanUp")
    public LifeCycleBean lifeCycleBean(NotificationService notificationService) {

        /*
        ===============================================================
        STEP 8

        Before executing this method,
        Spring resolves dependencies.

        It searches the container for a bean
        implementing NotificationService.

        When found → Spring injects it here.
        // Injection means giving that stored object to another class that needs it.
        ===============================================================
        */

        /*
        ===============================================================
        STEP 9

        Spring now creates LifeCycleBean object.

        This calls the constructor of LifeCycleBean.
        ===============================================================
        */
        return new LifeCycleBean(notificationService);
    }
}