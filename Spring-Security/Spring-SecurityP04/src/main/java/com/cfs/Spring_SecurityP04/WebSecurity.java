package com.cfs.Spring_SecurityP04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * 👉 @Configuration
 * Batata hai ki ye class Spring Security configuration ke liye hai
 */
@Configuration

/*
 * 👉 @EnableWebSecurity
 * Spring Security ko enable karta hai (filters activate hote hain)
 */
@EnableWebSecurity
public class WebSecurity {

    /*
     * 👉 Custom UserDetailsService
     * Authentication ke time DB se user load karne ke liye
     */
    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    /*
     * 👉 SecurityFilterChain
     * Ye poora security flow define karta hai:
     * - kaunsa URL public hai
     * - kaunsa role kis URL ko access karega
     * - kaunsa authentication method use hoga
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                // CSRF disable (REST APIs ke liye common hai)
                .csrf(csrf -> csrf.disable())

                // Authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Public APIs (no authentication required)
                        .requestMatchers("/api/public", "/api/addUsers","/error").permitAll()

                        // USER role wale users ke liye
                        .requestMatchers("/api/user").hasRole("USER")

                        // ADMIN role wale users ke liye
                        .requestMatchers("/api/admin").hasRole("ADMIN")

                        // Baaki sab endpoints ke liye authentication mandatory
                        .anyRequest().authenticated()
                )

                // HTTP Basic authentication enable
                .httpBasic(Customizer.withDefaults());

        // Security filter chain build karna
        return httpSecurity.build();
    }

    /*
     * 👉 AuthenticationManager Bean
     * Username + Password ko authenticate karta hai
     * Internally UserDetailsService + PasswordEncoder use hota hai
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
            AuthenticationManager authenticationManager = configuration.getAuthenticationManager();
        System.out.println("AuthenticationManager method called....");
            return authenticationManager;
    }

    /*
     * 👉 PasswordEncoder Bean
     * Password ko encode (hash) karne ke liye
     * Login ke time password match bhi yahi karta hai
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("PasswordEncoder method called .....");
        return bCryptPasswordEncoder;
    }

}
