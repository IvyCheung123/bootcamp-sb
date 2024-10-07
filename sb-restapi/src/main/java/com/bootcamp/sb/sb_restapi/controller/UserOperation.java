package com.bootcamp.sb.sb_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sb.sb_restapi.model.User;

public interface UserOperation {
  @GetMapping(value = "/users")
  User[] getUsers();

  @GetMapping(value = "/user") // user?userId=0
  User getUser(@RequestParam String userId);
}
