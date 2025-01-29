package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class demoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails mary = User.builder().roles("EMPLOYEE")
                .username("mary")
                .password("{noop}mary123")
                .build();

        UserDetails susan = User.builder().roles("EMPLOYEE", "MANAGER")
                .username("susan")
                .password("{noop}susan123")
                .build();

        UserDetails john = User.builder().roles("EMPLOYEE", "ADMIN")
                .username("john")
                .password("{noop}john123")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}
