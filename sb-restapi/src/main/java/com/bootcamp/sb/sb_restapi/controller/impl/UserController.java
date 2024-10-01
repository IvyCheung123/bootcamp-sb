package com.bootcamp.sb.sb_restapi.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.sb_restapi.controller.UserOperation;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.service.UserService;

@RestController // @Controller + @Response
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;

  @Override
  public User[] getUsers() {
    return userService.getUsers();
  }
}
