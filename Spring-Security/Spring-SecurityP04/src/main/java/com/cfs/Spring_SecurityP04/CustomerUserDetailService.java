package com.cfs.Spring_SecurityP04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * 👉 UserDetailsService ka kaam hota hai
 * Authentication ke time DB se user ka data load karna
 *
 * Flow:
 * Spring Security → UserDetailsService → JPA Repository → Database
 */

@Service
public class CustomerUserDetailService implements UserDetailsService {

    /*
     * 👉 JPA Repository
     * Database se user fetch karne ke liye
     */
    @Autowired
    private UserRepository userRepository;

    /*
     * 👉 Spring Security automatically is method ko call karta hai
     * jab login request aati hai
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername method called .....");
        /*
         * 👉 Database se user ko username ke basis par load karna
         * Agar user nahi mila → exception throw
         */
        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Debug purpose
        System.out.println("Found username = " + user.getUsername() + " / " + user.getPassword());

        /*
         * 👉 AppUser ko Spring Security ke UserDetails object me convert karna
         *  yahi data Security authentication & authorization me use hota hai
         */
        return new User(
                user.getUsername(),          // username
                user.getPassword(),          // encoded password
                user.isEnabled(),             // enabled
                true,                         // accountNonExpired
                true,                         // credentialsNonExpired
                true,                         // accountNonLocked
                // Roles ko GrantedAuthority me convert karna
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).toList()
        );
    }
}
