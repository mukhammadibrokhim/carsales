package com.carsales.carsales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(
                        "/favicon.ico",
                        "/**/*.ico",
                        "/**/*.png",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/csrf",
                        "/static/**",
                        "/login/**",
                        "/webjars/**"
                ).permitAll()
//                .antMatchers(HttpMethod.GET, "/admin/**").hasAnyRole("ADMIN","SUPPER_ADMIN","USER")
                .anyRequest().permitAll();
        return http.build();

    }
}
