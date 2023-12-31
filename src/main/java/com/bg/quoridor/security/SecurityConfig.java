package com.bg.quoridor.security;

import static org.springframework.security.config.Customizer.withDefaults;

import com.bg.quoridor.services.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  private final JpaUserDetailsService myUserDetailsService;

  public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
    this.myUserDetailsService = myUserDetailsService;
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests
                .requestMatchers("/check").hasRole("USER")
                .requestMatchers("/login").permitAll()
                .requestMatchers("/register").permitAll()
                .anyRequest().authenticated()
        )
        .userDetailsService(myUserDetailsService)
        .httpBasic(withDefaults())
        .build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
