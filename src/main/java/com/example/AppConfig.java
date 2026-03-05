package com.example;

import com.loose.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
====================================================================
STEP 1:
When Spring sees @Configuration,
it understands:

➡ This class contains instructions to create beans.
➡ Spring will read this class during container startup.
====================================================================
*/
@Configuration


/*
====================================================================
STEP 2:
@ComponentScan tells Spring:

➡ Go inside these packages.
➡ Search for classes with @Component, @Service, @Repository, etc.
➡ If found, create objects automatically.
➡ Store them inside the IoC container.

Important:
ComponentScan runs during container initialization.
====================================================================
*/
@ComponentScan(basePackages = {"com.example", "com.loose"})
public class AppConfig {


    /*
    ====================================================================
    STEP 3:
    Spring sees this @Bean method during startup.

    Important Concept:

    ❌ Spring does NOT immediately execute this method.
    ✅ Spring only registers it as a Bean Definition.

    What Spring stores internally:

        Bean Name       -> lifeCycleBean
        Bean Class       -> LifeCycleBean
        Init Method      -> init
        Destroy Method   -> cleanUp
        Dependencies     -> NotificationService

    So Spring remembers:
    "When I create this bean, I must call init().
     When container closes, I must call cleanUp()."
    ====================================================================
    */
    @Bean(initMethod = "init", destroyMethod = "cleanUp")
    public LifeCycleBean lifeCycleBean(NotificationService notificationService) {

        /*
        ====================================================================
        STEP 4:
        Before executing this method,
        Spring checks:

        ➜ Is there a bean in the container
           that implements NotificationService?

        If yes → Inject it here automatically.

        This is Dependency Injection.

        Spring now creates the LifeCycleBean object.
        Constructor will run at this point.
        ====================================================================
        */

        return new LifeCycleBean(notificationService);
    }
}