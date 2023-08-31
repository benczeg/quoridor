package com.bg.quoridor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue
  private Long id;
  private String username;
  private String password;
  private String roles;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.roles = "USER";
  }
}
