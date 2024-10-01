package com.myfirst_springapp.springapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

        @Bean
        public InMemoryUserDetailsManager userDetailsManager() {

                UserDetails avish = User.builder()
                                .username("avish")
                                .password("{noop}avishtomar")
                                .roles("EMPLOYEE")
                                .build();
                UserDetails john = User.builder()
                                .username("john")
                                .password("{noop}avishtomar")
                                .roles("EMPLOYEE", "MANAGER")
                                .build();
                UserDetails saurabh = User.builder()
                                .username("saurabh")
                                .password("{noop}avishtomar")
                                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                                .build();

                return new InMemoryUserDetailsManager(avish, john, saurabh);
        }
}