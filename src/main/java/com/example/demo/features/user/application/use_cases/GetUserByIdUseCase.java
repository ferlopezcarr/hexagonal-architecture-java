package com.example.demo.features.user.application.use_cases;

import org.springframework.stereotype.Service;

import com.example.demo.features.user.domain.User;
import com.example.demo.features.user.domain.UserAge;
import com.example.demo.features.user.domain.UserEmail;
import com.example.demo.features.user.domain.UserId;
import com.example.demo.features.user.domain.UserLastname;
import com.example.demo.features.user.domain.UserName;

@Service
public class GetUserByIdUseCase {

  public User execute(int id) {
    UserId userId = new UserId(1);
    UserEmail userEmail = new UserEmail("user@user.com");
    UserName userName = new UserName("name");
    UserLastname userLastname = new UserLastname("lastname");
    UserAge age = new UserAge(18);
    return new User(userId, userEmail, userName, userLastname, age);
  }

}
