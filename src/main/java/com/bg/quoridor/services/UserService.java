package com.bg.quoridor.services;

import com.bg.quoridor.models.User;

public interface UserService {

  void createUser(User user);
  boolean loginUser(User user);

}
