package com.bootcamp.sb.sb_restapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.sb.sb_restapi.model.NewPost;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.UserRequest;

public interface PostOperation {
  @GetMapping(value = "/posts")
  Post[] getPosts();

  @GetMapping(value = "/posts/{postId}")
  Post getPost(@PathVariable String postId);

  // @PostMapping(value = "/create/post/{userId}")
  // @ResponseStatus(HttpStatus.CREATED)
  // Post createNewPost(@PathVariable String userId, @RequestBody NewPost newPost);
}