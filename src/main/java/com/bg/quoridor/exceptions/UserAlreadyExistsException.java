package com.bg.quoridor.exceptions;

public class UserAlreadyExistsException extends Exception{
  public String message() {
    return "User already exists.";
  }
}
