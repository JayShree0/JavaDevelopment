package com.cfs.Spring_Security_P02.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
    {
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/about", "/contactUs").permitAll()
                .requestMatchers("/transfer", "/admin").authenticated()
        )
//                .formLogin(Customizer.withDefaults());
                // Enables default FORM-BASED LOGIN (login page in browser with username & password form)

                .httpBasic(Customizer.withDefaults());
                // Enables HTTP BASIC AUTHENTICATION (credentials sent in Authorization header, commonly used by Postman, REST clients, APIs)

        return httpSecurity.build();
    }
}
