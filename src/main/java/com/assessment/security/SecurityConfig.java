package com.assessment.security;

import com.assessment.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private AdminService adminService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disables CSRF protection to allow unauthenticated post
                .authorizeHttpRequests(req->req
                        // allow the login and signup page and endpoints to be accessed without authentication
//                        .requestMatchers(HttpMethod.POST, "/signup/post").permitAll()
                        .requestMatchers("/signup/**").permitAll()
                        .anyRequest().authenticated())

                //                .formLogin(Customizer.withDefaults()) // using Spring default login page
                .formLogin((form) -> form
                        .loginPage("/admin/login")
                        .defaultSuccessUrl("/admin/dashboard", true)
                        .permitAll()
                )

                .userDetailsService(adminService).build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}