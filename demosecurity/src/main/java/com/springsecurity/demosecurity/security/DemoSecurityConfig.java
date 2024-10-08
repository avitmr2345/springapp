package com.springsecurity.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

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
                        .permitAll() // allow everyone to see login page. No need to be logged in
                )
                .logout(logout -> logout.permitAll()); // adds logout support for default URL /logout
        return http.build();
    }
}
