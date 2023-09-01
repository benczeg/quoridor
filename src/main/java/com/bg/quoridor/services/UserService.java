package com.bg.quoridor.services;

import com.bg.quoridor.exceptions.InvalidPasswordException;
import com.bg.quoridor.exceptions.UserAlreadyExistsException;
import com.bg.quoridor.exceptions.UserNotExistsException;
import com.bg.quoridor.models.User;

public interface UserService {
  void addNewUser(User user) throws UserAlreadyExistsException;

  void authenticateUser(User user) throws InvalidPasswordException, UserNotExistsException;
}
