package com.bootcamp.sb.sb_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sb.sb_restapi.model.UserPostDTO;

public interface DTOOperation {
  @GetMapping(value = "/userpost/{userId}") // userpost/1?postId=1
  UserPostDTO getUserPostDTO(@PathVariable String userId, 
    @RequestParam(defaultValue = "0") String postId);
}
