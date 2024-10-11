package com.bootcamp.sb.sb_restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.UserRequest;

public interface UserOperation {
  @GetMapping(value = "/users")
  User[] getUsers();

  @GetMapping(value = "/user") // user?userId=0
  User getUser(@RequestParam String userId);

  @PostMapping(value = "/create/user")
  @ResponseStatus(HttpStatus.CREATED)
  User createNewUser(@RequestBody UserRequest userRequest);
}
