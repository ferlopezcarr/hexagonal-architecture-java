package com.example.demo.features.user.infraestructure.drivers.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.features.user.application.use_cases.GetUserByIdUseCase;
import com.example.demo.features.user.domain.User;
import com.example.demo.features.user.infraestructure.drivers.models.UserApi;
import com.example.demo.features.user.infraestructure.drivers.ports.UserApiPort;

@RestController
@RequestMapping("/user")
public class UserApiAdapter implements UserApiPort {

  @Autowired
  public GetUserByIdUseCase getUserByIdUseCase;

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<UserApi> getUserById(Integer id) {
    User user = this.getUserByIdUseCase.execute(id);
    return ResponseEntity.ok(new UserApi(
        user.getId().getId(),
        user.getEmail().getEmail(),
        user.getName().getName(),
        user.getLastname().getLastname(),
        user.getAge().getAge()));
  }

}
