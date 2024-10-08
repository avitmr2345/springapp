package com.springsecurity.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage") // show our custom form at the request mapping
                        .loginProcessingUrl("/authenticateTheUser") // login form should POST data to this URL for
                                                                    // processing (check user id and password). Login
                                                                    // processing URL will be handled by Spring Security
                                                                    // Filters
                        .permitAll()); // allow everyone to see login page. No need to be logged in

        return http.build();
    }
}
