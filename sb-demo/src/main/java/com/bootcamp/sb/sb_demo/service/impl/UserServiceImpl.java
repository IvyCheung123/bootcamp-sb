package com.bootcamp.sb.sb_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.sb.sb_demo.infra.ApiUtil;
import com.bootcamp.sb.sb_demo.infra.Scheme;
import com.bootcamp.sb.sb_demo.model.User;
import com.bootcamp.sb.sb_demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private ApiUtil apiUtil;

  @Value("${api.url.endpoint.user}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public User[] getUsers() {
    User[] users = restTemplate.getForObject(apiUtil.getUrl(Scheme.HTTPS, endpoint), User[].class);
    return users;
  }
}
