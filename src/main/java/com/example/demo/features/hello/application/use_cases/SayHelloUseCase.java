package com.example.demo.features.hello.application.use_cases;

import org.springframework.stereotype.Service;

@Service
public class SayHelloUseCase {

  public String execute() {
    return "Hello World!";
  }

}
