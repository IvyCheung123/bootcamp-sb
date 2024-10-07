package com.bootcamp.sb.sb_restapi.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.sb.sb_restapi.model.PostDTO;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.UserPostDTO;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.service.DTOService;
import com.bootcamp.sb.sb_restapi.service.PostService;
import com.bootcamp.sb.sb_restapi.service.UserService;

@Service
public class DTOServiceHolder implements DTOService {
  @Autowired
  private PostService postService;

  @Autowired
  private UserService userService;

  @Autowired
  private Mapper mapper;

  @Override
  public UserPostDTO getUserPostDTO(Long userId, Long postId) {
    User user = userService.getUser(userId);
    UserPostDTO userPostDTO = mapper.mapUserToUserPostDTO(user);

    if (postId == 0) {
      List<PostDTO> posts = postService.getPostsByUserId(userId);
      userPostDTO.setPostDTO(posts);
    } else {
      List<PostDTO> posts = Optional.ofNullable(postService.getPost(postId))
        .filter(post -> post.getUserId().equals(userId))
        .map(post -> List.of(mapper.mapPostToPostDTO(post)))
        .orElse(List.of());
      userPostDTO.setPostDTO(posts);
    }
    return userPostDTO;
  }
}
