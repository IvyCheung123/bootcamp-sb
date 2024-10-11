package com.bootcamp.sb.sb_restapi.service.impl;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.sb.sb_restapi.entity.PostEntity;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.lib.Scheme;
import com.bootcamp.sb.sb_restapi.lib.UrlManager;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.PostDTO;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.repository.PostRepository;
import com.bootcamp.sb.sb_restapi.service.PostService;

@Service
public class PostServiceHolder implements PostService {
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint.post}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public Post[] getPosts() {
    String url = UrlManager.builder()
      .scheme(Scheme.HTTPS)
      .domain(this.domain)
      .endpoint(this.endpoint)
      .build()
      .toString();
    
    Post[] posts = this.restTemplate.getForObject(url, Post[].class);

    if (postRepository.findAll().size() == 0) {
      Arrays.asList(posts).stream()
        .forEach(post -> {
          PostEntity postEntity = mapper.mapPostToPostEntity(post);
          postRepository.save(postEntity);
        });
    } else {
      System.out.println("Already have data");
    }
    return posts;
  }

  @Override
  public Post getPost(Long postId) {
    return Arrays.stream(this.getPosts())
      .filter(post -> post.getId().equals(postId))
      .findFirst()
      .get();
  }

  @Override
  public List<PostDTO> getPostsByUserId(Long userId) {
    return Arrays.stream(this.getPosts())
      .filter(post -> post.getUserId().equals(userId))
      .map(post -> mapper.mapPostToPostDTO(post))
      .collect(Collectors.toList());
  }

  @Override
  public PostEntity createNewPost(Long userId, String title, String body) {
    return postRepository.save(PostEntity.builder()
      .userId(userId)
      .title(title)
      .body(body)
      .build());
  }
}
