package com.example.demo.features.user.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserLastname {

  @NotNull
  @NotEmpty
  @NotBlank
  private String lastname;

  public UserLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getLastname() {
    return this.lastname;
  }
}
