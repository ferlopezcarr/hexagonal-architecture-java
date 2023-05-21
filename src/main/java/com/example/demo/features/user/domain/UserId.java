package com.example.demo.features.user.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class UserId {

  @NotNull
  @Positive
  @Digits(integer = 0, fraction = 0)
  private int id;

  public UserId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

}
