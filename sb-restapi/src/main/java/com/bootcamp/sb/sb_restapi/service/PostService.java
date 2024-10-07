package com.bootcamp.sb.sb_restapi.service;

import java.util.List;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.PostDTO;

public interface PostService {
  Post[] getPosts();

  Post getPost(Long postId);

  List<PostDTO> getPostsByUserId(Long userId);
}
