// package com.myfirst_springapp.springapp.security;

// import javax.sql.DataSource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.provisioning.UserDetailsManager;
// // import org.springframework.security.core.userdetails.User;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class DemoSecurityConfig {

//         // @Bean
//         // public InMemoryUserDetailsManager userDetailsManager() {

//         // UserDetails avish = User.builder()
//         // .username("avish")
//         // .password("{noop}avishtomar")
//         // .roles("EMPLOYEE")
//         // .build();
//         // UserDetails john = User.builder()
//         // .username("john")
//         // .password("{noop}avishtomar")
//         // .roles("EMPLOYEE", "MANAGER")
//         // .build();
//         // UserDetails saurabh = User.builder()
//         // .username("saurabh")
//         // .password("{noop}avishtomar")
//         // .roles("EMPLOYEE", "MANAGER", "ADMIN")
//         // .build();

//         // return new InMemoryUserDetailsManager(avish, john, saurabh);
//         // }

//         @Bean
//         // Inject datasource which is auto-configured by SpringBoot
//         public UserDetailsManager userDetailsManager(DataSource datasource) {
//                 // it tells Spring Security to use JDBC authentication with our datasource
//                 return new JdbcUserDetailsManager(datasource);
//         }

//         @Bean
//         public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//                 http.authorizeHttpRequests(configurer -> configurer
//                                 .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
//                                 .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//                                 .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//                                 .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
//                                 .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

//                 // use HTTP basic authentication
//                 http.httpBasic(Customizer.withDefaults());

//                 // disable CSRF
//                 http.csrf(csrf -> csrf.disable());

//                 return http.build();
//         }
// }