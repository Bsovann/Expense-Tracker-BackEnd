package com.bondith.webappbackend.config;

import com.bondith.webappbackend.service.UserAccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * This class represents the application configuration.
 *
 * It is annotated with @Configuration, which indicates that this class provides bean definitions for the application context.
 * It is also annotated with @EnableWebSecurity, which enables Spring Security for the application.
 */
@Configuration
@EnableWebSecurity
public class AppConfiguration {

    @Autowired
    public UserAccountDetailService userAccountDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(customizer -> customizer.disable())
                .authorizeRequests(req -> req
                        .requestMatchers("/register").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userAccountDetailService);
        auth.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return auth;
    }
}
