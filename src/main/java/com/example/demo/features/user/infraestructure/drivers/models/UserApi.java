package com.example.demo.features.user.infraestructure.drivers.models;

public class UserApi {
  private int id;
  private String email;
  private String name;
  private String lastname;
  private int age;

  public UserApi(
      int id,
      String email,
      String name,
      String lastname,
      int age) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.lastname = lastname;
    this.age = age;
  }

  public int getId() {
    return this.id;
  }

  public String getEmail() {
    return this.email;
  }

  public String getName() {
    return this.name;
  }

  public String getLastname() {
    return this.lastname;
  }

  public int getAge() {
    return this.age;
  }
}
