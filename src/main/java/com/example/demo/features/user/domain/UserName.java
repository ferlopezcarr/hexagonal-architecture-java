package com.example.demo.features.user.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserName {

  @NotNull()
  @NotEmpty()
  @NotBlank()
  private String name;

  public UserName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
