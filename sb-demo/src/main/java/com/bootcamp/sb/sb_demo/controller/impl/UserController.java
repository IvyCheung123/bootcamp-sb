package com.bootcamp.sb.sb_demo.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.sb_demo.controller.UserOperation;
import com.bootcamp.sb.sb_demo.model.User;
import com.bootcamp.sb.sb_demo.service.UserService;

@RestController
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;

  @Override
  public List<User> getUsers() {
    return List.of(userService.getUsers());
  }
}
