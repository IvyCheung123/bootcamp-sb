package com.bootcamp.sb.sb_restapi.controller.impl;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.sb_restapi.controller.UserOperation;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.exception.BusinessException;
import com.bootcamp.sb.sb_restapi.exception.ErrorCode;
import com.bootcamp.sb.sb_restapi.exception.UserIdNotFoundException;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.UserRequest;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.repository.UserRepository;
import com.bootcamp.sb.sb_restapi.service.UserService;

@RestController // @Controller + @Response
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;

  @Autowired
  private Mapper mapper;

  @Autowired
  private UserRepository userRepository;

  @Override
  public User[] getUsers() {
    return userService.getUsers();
  }

  @Override
  public User getUser(String userId) {
    return userService.getUser(Long.parseLong(userId));
  }

  @Override
  public User createNewUser(@RequestBody UserRequest userRequest) {
    String name = userRequest.getName();
    String email = userRequest.getEmail();
    String phone = userRequest.getPhone();
    return mapper.mapUserEntityToUser(userService.createNewUser(name, email, phone));
  }

  // @Override
  // public List<User> getUsersFromDB() {
  //   return this.userService.getUsersFromDB();
  // }

  // @Override
  // public User getUserFromDBById(@PathVariable Long id) {
  //   return this.userService.getUsersFromDB().stream()
  //     .filter(e -> e.getId().equals(id))
  //     .collect(Collectors.toList());
  // }

  // @Override
  // public UserEntity getUserFromDBById(@PathVariable Long id) {
  //   return this.userService.getUserFromDBById(id).orElse(null);
  // }

  @Override
  public UserEntity getUserFromDBById(@PathVariable Long id) {
    Optional<UserEntity> userEntity = this.userService.getUserFromDBById(id);
    if (userEntity.isPresent()) {
      return userEntity.get();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND_EXCEPTION);
  }

  // @Override
  // public Boolean deleteUserFromDBById(@PathVariable Long id) {
  //   return this.userService.deleteUserFromDBById(id);
  // }

  @Override
  public void deleteUserFromDBById(@PathVariable Long id) {
    this.userService.deleteUserFromDBById(id);
  }

  @Override
  public User modifyUser(Long id, UserRequest userRequest) {
    Optional<UserEntity> targetUser = userRepository.findById(id);
    if (targetUser.isPresent()) {
      targetUser.get().setName(userRequest.getName());
      targetUser.get().setEmail(userRequest.getEmail());
      targetUser.get().setPhone(userRequest.getPhone());
      userRepository.save(targetUser.get());
    }
    throw new UserIdNotFoundException(ErrorCode.USER_ID_NOT_FOUND_EXCEPTION);
  }

  @Override
  public User updateEmail(Long id, String email) {
    Optional<UserEntity> targetUser = userRepository.findById(id);
    UserEntity existUser = targetUser.get();
    existUser.setEmail(email);
    userRepository.save(existUser);
    return mapper.mapUserEntityToUser(existUser);
  }
}
