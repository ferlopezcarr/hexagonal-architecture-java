package com.example.demo.features.user.domain;

import javax.validation.constraints.NotNull;

public class User {

  @NotNull
  private UserId id;

  @NotNull
  private UserEmail email;

  @NotNull
  private UserName name;

  @NotNull
  private UserLastname lastname;

  @NotNull
  private UserAge age;

  public User(
      UserId id,
      UserEmail email,
      UserName name,
      UserLastname lastname,
      UserAge age) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.lastname = lastname;
    this.age = age;
  }

  public UserId getId() {
    return this.id;
  }

  public UserEmail getEmail() {
    return this.email;
  }

  public UserName getName() {
    return this.name;
  }

  public UserLastname getLastname() {
    return this.lastname;
  }

  public UserAge getAge() {
    return this.age;
  }

}
