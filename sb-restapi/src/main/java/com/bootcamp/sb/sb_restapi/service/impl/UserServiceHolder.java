package com.bootcamp.sb.sb_restapi.service.impl;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.lib.Scheme;
import com.bootcamp.sb.sb_restapi.lib.UrlManager;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.repository.UserRepository;
import com.bootcamp.sb.sb_restapi.service.UserService;

@Service
public class UserServiceHolder implements UserService {
  // Call API
  // private static final String url = "https://jsonplaceholder.typicode.com/users";
  
  // Before @Service bean created, Spring find @Value from application.yml
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint.user}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mapper mapper;

  // @Autowired
  // public UserServiceHolder(@Value("${api.url.domain}") String domain, 
  // @Value("${api.url.endpoint}") String endpoint, RestTemplate restTemplate) {
  //   this.domain = domain;
  //   this.endpoint = endpoint;
  //   this.restTemplate = restTemplate;
  // }

  @Override
  public User[] getUsers() {
    String url = UrlManager.builder()
      .scheme(Scheme.HTTPS)
      .domain(this.domain)
      .endpoint(this.endpoint)
      .build()
      .toString();

    User[] users = this.restTemplate.getForObject(url, User[].class);

    if (userRepository.findAll().size() == 0) {
      Arrays.asList(users).stream()
        .forEach(user -> {
        // convert User object to UserEntity object
        UserEntity userEntity = mapper.mapUserToUserEntity(user);
        userRepository.save(userEntity);
      });
    } else {
      System.out.println("Alreadly have data");
    }
    return users;
  }

  @Override
  public User getUser(Long userId) {
    return Arrays.stream(this.getUsers())
      .filter(user -> user.getId().equals(userId))
      .findFirst()
      .get();
  }
}
