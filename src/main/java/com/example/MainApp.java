package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // Step 1: Create IOC Container
        // Spring reads AppConfig
        // Then scans packages
        // Then creates beans
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//
//
//        // Step 2: Ask container for bean with name "myBean"
//        GreetingService greetingService =
//                (GreetingService) context.getBean("myBean");
//
//
//        // Step 3: Call method on bean
//        greetingService.sayHello();
//


        // ----------------------------------------------------- //








                // Step 1: Program starts from main method
                // JVM begins execution from here
                System.out.println("Starting Spring Application Context");

                // Step 2: Creating the Spring IoC Container
                // AnnotationConfigApplicationContext is a container implementation

                // What Spring does internally here:

                // 1. Create IoC container object
                // 2. Read configuration class AppConfig
                // 3. Process annotations like:
                //      @Configuration
                //      @ComponentScan
                //      @Bean
                // 4. Start scanning packages for components
                // 5. Create beans and store them inside IoC container

                ApplicationContext context =
                        new AnnotationConfigApplicationContext(AppConfig.class);


                // Step 3: Request bean from IoC container

                System.out.println("Retrieving Lifecycle Bean");

                // Here Spring searches inside IoC container:
                // "Do I have an object of LifeCycleBean?"

                // Since LifeCycleBean is defined using @Bean in AppConfig
                // Spring already created the object during container startup

                LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);


                // Step 4: Using the bean

                lifeCycleBean.performTask();


                // Step 5: Application finishing

                System.out.println("Closing Spring Context");

                // NOTE:
                // destroy method will run ONLY if container is closed
                // Example:
                // ((AnnotationConfigApplicationContext) context).close();

            }
        }

