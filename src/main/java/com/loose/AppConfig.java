package com.loose;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Tells Spring -> This is a configuration class
//@Configuration tells Spring that this class contains configuration instructions and should be read when creating the IoC container.
@Configuration

// “Spring, go inside the package com.example
// Find all classes
// If any class has @Component (or @Service, @Repository, etc.)
// Create object for it
// Store it inside the IoC container”
@ComponentScan(basePackages = "com.loose")
public class AppConfig {
}
