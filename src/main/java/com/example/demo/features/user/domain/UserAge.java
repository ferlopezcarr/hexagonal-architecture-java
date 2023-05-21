package com.example.demo.features.user.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

public class UserAge {

  @Positive
  @Digits(integer = 0, fraction = 0)
  private int age;

  public UserAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }
}
