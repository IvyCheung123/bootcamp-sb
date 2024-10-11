package com.bootcamp.sb.sb_restapi.service;

import org.springframework.stereotype.Service;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.model.User;

public interface UserService {
  User[] getUsers();

  User getUser(Long userId);

  UserEntity createNewUser(String name, String email, String phone);
}
