package com.bootcamp.sb.sb_demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sb.sb_demo.model.User;

public interface UserOperation {
  @GetMapping(value = "/users")
  List<User> getUsers();
}
