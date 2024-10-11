package com.bootcamp.sb.sb_restapi.controller.impl;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Schema;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.sb.sb_restapi.controller.PostOperation;
import com.bootcamp.sb.sb_restapi.model.NewPost;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.UserRequest;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.service.PostService;

@RestController
public class PostController implements PostOperation {
  @Autowired
  private PostService postService;

  @Autowired
  private Mapper mapper;
  
  @Override
  public Post[] getPosts() {
    return postService.getPosts();
  }

  @Override
  public Post getPost(String postId) {
    return postService.getPost(Long.parseLong(postId));
  }

  @Override
  public Post createNewPost(@PathVariable String userId, @RequestBody NewPost newPost) {
    String title = newPost.getTitle();
    String body = newPost.getBody();
    return mapper.mapPostEntityToPost(postService.createNewPost(Long.parseLong(userId), title, body));
  }
}