package com.bootcamp.sb.sb_restapi.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.sb_restapi.controller.PostOperation;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.service.PostService;

@RestController
public class PostController implements PostOperation {
  @Autowired
  private PostService postService;
  
  @Override
  public Post[] getPosts() {
    return postService.getPosts();
  }

  @Override
  public Post getPost(String postId) {
    return postService.getPost(Long.parseLong(postId));
  }
}