package com.bg.quoridor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

//  @Autowired
//  private UserService userService;

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
  @ResponseBody
  public String register() {
    return "register";
  }
}
