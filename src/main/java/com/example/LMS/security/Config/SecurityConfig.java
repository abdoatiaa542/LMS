package com.example.LMS.security.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("weeeeeeeeeeeee");
        try {
            System.out.println("a7a");
            http.httpBasic(Customizer.withDefaults());
            http.csrf().disable().authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/admin/**").permitAll()
                    .requestMatchers("/api/attendance/**").permitAll()
                    .requestMatchers("/classes/**").permitAll()
                    .requestMatchers("/categories/**").permitAll()
                    .anyRequest().authenticated()

            );
            http.formLogin(Customizer.withDefaults());
            http.cors(AbstractHttpConfigurer::disable);
            return http.build();

        } catch (Exception e) {
            System.out.println("هخخخخخخخخخخخخخخخخخخخخخخخخخ");
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}