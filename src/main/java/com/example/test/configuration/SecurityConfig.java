package com.example.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity; enable in production if needed
            .authorizeHttpRequests(authz -> authz
            		  .requestMatchers("/getusers").hasRole("USER") // Accessible only by users with the USER role
                      .requestMatchers("/saveuser").hasRole("ADMIN") // Accessible only by admins
                      .requestMatchers("/{id}").hasAnyRole("USER", "ADMIN") // Allow access to GET, PUT, and DELETE by USER and ADMIN roles
                .anyRequest().authenticated() // Secure other endpoints
            )
            .httpBasic(); // Use Basic Authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
    	 UserDetails user = User.withUsername("user")
                 .password("{noop}password") // NoOp encoder for demonstration only; use secure encoder in production
                 .roles("USER")
                 .build();
         UserDetails admin = User.withUsername("admin")
                 .password("{noop}password")
                 .roles("ADMIN")
                 .build();
         return new InMemoryUserDetailsManager(user, admin);
    }
}

