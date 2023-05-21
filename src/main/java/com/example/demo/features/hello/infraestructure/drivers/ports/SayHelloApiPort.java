package com.example.demo.features.hello.infraestructure.drivers.ports;

import org.springframework.http.ResponseEntity;

public interface SayHelloApiPort {
  public ResponseEntity<String> sayHello();
}
