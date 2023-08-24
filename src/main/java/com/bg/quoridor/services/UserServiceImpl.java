package com.bg.quoridor.services;

import com.bg.quoridor.models.User;
import com.bg.quoridor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void createUser(User user) {
    if (!userRepository.existsByUsername(user.userName)) {
      userRepository.save(user);
    }
  }

  @Override
  public boolean loginUser(User user) {
    return userRepository.existsByUsername(user.userName);
  }
}
