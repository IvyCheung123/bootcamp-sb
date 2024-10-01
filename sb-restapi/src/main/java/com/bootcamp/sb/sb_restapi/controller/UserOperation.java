package com.bootcamp.sb.sb_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sb.sb_restapi.model.User;

public interface UserOperation {
  @GetMapping(value = "/users")
  User[] getUsers();
}
