package com.bg.quoridor.services;

import com.bg.quoridor.exceptions.InvalidPasswordException;
import com.bg.quoridor.exceptions.UserAlreadyExistsException;
import com.bg.quoridor.exceptions.UserNotExistsException;
import com.bg.quoridor.models.User;
import com.bg.quoridor.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository,
                         PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void addNewUser(User user) throws UserAlreadyExistsException {
    Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
    if (optionalUser.isPresent()) {
      throw new UserAlreadyExistsException();
    } else {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRoles("USER");
      userRepository.save(user);
    }
  }

  @Override
  public void authenticateUser(User user) throws InvalidPasswordException, UserNotExistsException {
    Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
    if (optionalUser.isPresent()) {
      if(optionalUser.get().getPassword().equals(user.getPassword())){
        //return token + 200ok
      }else{
        throw new InvalidPasswordException();
      }
    } else {
      throw new UserNotExistsException();
    }
  }

}
