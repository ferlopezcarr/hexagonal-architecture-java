package com.example.demo.features.user.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserEmail {

  @NotNull
  @NotBlank()
  @Email
  private String email;

  public UserEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

}