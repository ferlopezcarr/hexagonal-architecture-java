package com.example.demo.features.auth.application.models;

public class UserJwtPayload {
  private int id;
  private String email;

  public UserJwtPayload(int id, String email) {
    this.id = id;
    this.email = email;
  }

  public int getId() {
    return this.id;
  }

  public String getEmail() {
    return this.email;
  }
}
