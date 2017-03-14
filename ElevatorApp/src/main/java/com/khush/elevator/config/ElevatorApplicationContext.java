package com.khush.elevator.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by khush on 14/03/2017.
 */
public class ElevatorApplicationContext {

    private static final String environment = System.getenv("env");
    private static AnnotationConfigApplicationContext instance;

    private ElevatorApplicationContext() {}

    public synchronized static AbstractApplicationContext getInstance() {
        if (instance == null) {
            if (System.getProperty("spring.profiles.active") == null) {
                System.setProperty("spring.profiles.active", (environment == null) ? "test" : environment);
            }
            instance = new AnnotationConfigApplicationContext("com.khush.elevator");
        }
        return instance;
    }
}
