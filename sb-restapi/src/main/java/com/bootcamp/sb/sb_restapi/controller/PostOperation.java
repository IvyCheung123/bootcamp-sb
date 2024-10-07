package com.bootcamp.sb.sb_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.sb.sb_restapi.model.Post;

public interface PostOperation {
  @GetMapping(value = "/posts")
  Post[] getPosts();

  @GetMapping(value = "/posts/{postId}")
  Post getPost(@PathVariable String postId);
}