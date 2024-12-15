package com.myfirst_springapp.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.myfirst_springapp.springapp.Coach;
import com.myfirst_springapp.springapp.SwimCoach;

@Configuration
public class SportConfig {

    @Bean
    Coach swimCoach() {
        return new SwimCoach();
    }
}
