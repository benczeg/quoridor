package com.bg.quoridor.services;

import com.bg.quoridor.exceptions.UserAlreadyExistsException;
import com.bg.quoridor.models.User;

public interface UserService {
  void addNewUser(User user) throws UserAlreadyExistsException;
}
