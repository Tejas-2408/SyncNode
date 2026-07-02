package com.example.syncnode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())  // disabled for local testing via postman
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    public UserDetailsService userDetailsService(){
        // Mock users representing different team members assigning tasks
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("alice")
                .password("password")
                .roles("USER").build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("bob")
                .password("password")
                .roles("USER").build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
