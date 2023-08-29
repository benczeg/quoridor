package com.bg.quoridor.controllers;

import com.bg.quoridor.exceptions.UserAlreadyExistsException;
import com.bg.quoridor.models.User;
import com.bg.quoridor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public String login() {
    return "login";
  }

  @GetMapping("register")
  public String registerPage() {
    return "register";
  }

  @PostMapping("register")
  public String registerNewUser(User user) throws UserAlreadyExistsException {
    System.out.println(user.getUsername());
    userService.addNewUser(user);
    return "register";
  }

  @PreAuthorize("hasRole('USER')")
  @ResponseBody
  @GetMapping("/check")
  public String check() {
    return "you are logged in";
  }

}
