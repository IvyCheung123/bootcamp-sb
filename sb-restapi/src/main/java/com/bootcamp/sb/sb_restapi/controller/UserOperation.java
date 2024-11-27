package com.bootcamp.sb.sb_restapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.lib.GeneralResponse;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.UserRequest;

public interface UserOperation {
  @GetMapping(value = "/users")
  User[] getUsers();

  @GetMapping(value = "/user") // user?userId=0
  User getUser(@RequestParam String userId);

  @PostMapping(value = "/create/user")
  @ResponseStatus(HttpStatus.CREATED)
  User createNewUser(@RequestBody UserRequest userRequest); // create from 0 to 1

  @GetMapping(value = "/db/user/{id}")
  UserEntity getUserFromDBById(@PathVariable Long id);

  // @DeleteMapping(value = "/db/user/{id}")
  // Boolean deleteUserFromDBById(@PathVariable Long id);

  @DeleteMapping(value = "/db/user/{id}")
  void deleteUserFromDBById(@PathVariable Long id);

  @PutMapping(value = "/db/user/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  User modifyUser(@RequestParam Long id, @RequestBody UserRequest userRequest); // update entire row

  @PatchMapping(value = "/db/user/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  User updateEmail(@RequestParam Long id, @RequestParam String email); // update email only

  // Controller layer: UserEntity -> User -> GeneralResponse<User>
  @GetMapping(value = "/getUserByUsername")
  GeneralResponse<User> getUserByUsername(@RequestParam String username);
}
