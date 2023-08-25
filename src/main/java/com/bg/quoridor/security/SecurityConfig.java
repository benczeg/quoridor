package com.bg.quoridor.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@EnableWebSecurity
public class SecurityConfig  {

  //@Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // TODO configure authentication manager
  }

 // @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO configure web security
  }
}
