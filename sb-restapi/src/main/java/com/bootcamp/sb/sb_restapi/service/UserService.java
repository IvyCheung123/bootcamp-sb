package com.bootcamp.sb.sb_restapi.service;

import org.springframework.stereotype.Service;
import com.bootcamp.sb.sb_restapi.model.User;

public interface UserService {
  User[] getUsers();
}
