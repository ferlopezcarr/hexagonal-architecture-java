package com.example.demo.features.user.infraestructure.drivers.ports;

import org.springframework.http.ResponseEntity;

import com.example.demo.features.user.infraestructure.drivers.models.UserApi;

public interface UserApiPort {
  public ResponseEntity<UserApi> getUserById(Integer id);
}
