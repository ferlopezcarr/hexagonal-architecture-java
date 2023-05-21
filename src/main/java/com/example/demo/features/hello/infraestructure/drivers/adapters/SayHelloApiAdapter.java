package com.example.demo.features.hello.infraestructure.drivers.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.features.hello.application.use_cases.SayHelloUseCase;
import com.example.demo.features.hello.infraestructure.drivers.ports.SayHelloApiPort;

@RestController
@RequestMapping("/hello")
public class SayHelloApiAdapter implements SayHelloApiPort {

  @Autowired
  private SayHelloUseCase sayHelloUseCase;

  @GetMapping("/")
  public ResponseEntity<String> sayHello() {
    String message = this.sayHelloUseCase.execute();
    return ResponseEntity.ok(message);
  }
}
