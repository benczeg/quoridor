package com.bg.quoridor.controllers;

import com.bg.quoridor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

  @Autowired
  private UserService userService;

  //@PreAuthorize("hasRole('USER')")
  @GetMapping("/")
  public String home() {
    //TODO check if logged in
    return "home";
  }

  @GetMapping("login")
  @ResponseBody
  public String login() {
    return "login";
  }

  @GetMapping("register")
  public String registerPage() {
    return "register";
  }

  @PostMapping("register")
  public String registerNewUser() {
    System.out.println("reg");
    return "register";
  }

}
