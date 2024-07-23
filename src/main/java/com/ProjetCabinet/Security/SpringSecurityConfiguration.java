package com.ProjetCabinet.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {


    @Bean
    PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}

    @Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("mouhcine")
            .password(passwordEncoder().encode("sanae"))
            .roles("ADMIN")
            .build();
        UserDetails user2 = User.withUsername("sanae")
                .password(passwordEncoder().encode("sanae"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}

