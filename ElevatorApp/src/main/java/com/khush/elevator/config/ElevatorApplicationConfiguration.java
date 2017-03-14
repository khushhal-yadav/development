package com.khush.elevator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by khush on 14/03/2017.
 */
public class ElevatorApplicationConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return  new PropertySourcesPlaceholderConfigurer();
    }

}
