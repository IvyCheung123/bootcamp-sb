package com.bootcamp.sb.sb_restapi.service.impl;

import java.util.List;
import java.time.Duration;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.sb.sb_restapi.entity.PostEntity;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.lib.RedisHelper;
import com.bootcamp.sb.sb_restapi.lib.Scheme;
import com.bootcamp.sb.sb_restapi.lib.UrlManager;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.PostDTO;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.repository.PostRepository;
import com.bootcamp.sb.sb_restapi.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  // @Autowired
  // private RedisTemplate<String, String> redisTemplate;

  // @Autowired
  // private ObjectMapper objectMapper;

  @Autowired
  private RedisHelper redisHelper;

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
          PostEntity postEntity = mapper.map(post);
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

  // @Override
  // public PostEntity createNewPost(Long id, String title, String body) {
  //   return postRepository.save(PostEntity.builder()
  //     .userId(id)
  //     .title(title)
  //     .body(body)
  //     .build());
  // }

  @Override
  public List<Post> getPostsFromWebsite() {
    String url = UrlManager.builder()
      .scheme(Scheme.HTTPS)
      .domain(this.domain)
      .endpoint(this.endpoint)
      .build()
      .toString();
    return Arrays.asList(restTemplate.getForObject(url, Post[].class));
  }

  @Override
  public List<PostEntity> getPostsFromRedis() throws JsonProcessingException {
    // Cache Pattern (Redis under 10ms >>> DB around 100ms)
    // Get from Redis
    // String json = this.redisTemplate.opsForValue().get("jph-posts");

    // If not, read from DB, and then write to Redis
    // if (json == null) {
    //   List<PostEntity> postEntities = this.postRepository.findAll();
    //   String jsonToWrite = this.objectMapper.writeValueAsString(postEntities);
    //   this.redisTemplate.opsForValue().set("jph-posts", jsonToWrite, Duration.ofSeconds(30));
    //   return postEntities;
    // }
    // return Arrays.asList(this.objectMapper.readValue(json, PostEntity[].class));

    List<PostEntity> postEntities = this.postRepository.findAll();
    this.redisHelper.set("jph-posts", postEntities, Duration.ofSeconds(10));
    return Arrays.asList(this.redisHelper.get("jph-posts", PostEntity[].class));
  }
}
