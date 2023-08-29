package com.bg.quoridor.services;

import com.bg.quoridor.exceptions.UserAlreadyExistsException;
import com.bg.quoridor.models.User;
import com.bg.quoridor.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void addNewUser(User user) throws UserAlreadyExistsException {
    Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
    if(optionalUser.isPresent()){
      throw new UserAlreadyExistsException();
    }else{
      userRepository.save(user);
    }
  }

}
