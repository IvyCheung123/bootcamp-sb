package com.bootcamp.sb.sb_restapi.service;

import java.util.List;
import com.bootcamp.sb.sb_restapi.entity.PostEntity;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.PostDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostService {
  Post[] getPosts();

  Post getPost(Long postId);

  List<PostDTO> getPostsByUserId(Long userId);

  // PostEntity createNewPost(Long userId, String title, String body);

  List<Post> getPostsFromWebsite();

  List<PostEntity> getPostsFromRedis() throws JsonProcessingException;
}
