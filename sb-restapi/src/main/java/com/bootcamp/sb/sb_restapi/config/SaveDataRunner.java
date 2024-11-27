package com.bootcamp.sb.sb_restapi.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.sb.sb_restapi.entity.CompanyEntity;
import com.bootcamp.sb.sb_restapi.entity.PostEntity;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.mapping.Mapper;
import com.bootcamp.sb.sb_restapi.repository.UserRepository;
import com.bootcamp.sb.sb_restapi.service.PostService;
import com.bootcamp.sb.sb_restapi.service.UserService;

@Component
public class SaveDataRunner implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private Mapper mapper;

  @Override
  public void run(String... args) throws Exception {
    // get users from website
    List<User> users = userService.getUsersFromWebsite();

    // get posts from website
    List<Post> posts = postService.getPostsFromWebsite();

    // construct List<UserEntity>
    // stream + filter
    // OneToMany
    List<UserEntity> userEntities = users.stream().map(u -> {
      UserEntity userEntity = mapper.map(u);

      List<PostEntity> postEntities = posts.stream()
      .filter(p -> p.getUserId().equals(u.getId()))
      .map(p -> {
        PostEntity postEntity = mapper.map(p);
        postEntity.setUserEntity(userEntity);
        return postEntity;
      })
      .collect(Collectors.toList());

      CompanyEntity companyEntity = mapper.mapUserToCompanyEntity(u.getCompany());
      companyEntity.setUserEntity(userEntity);

      userEntity.setPostEntities(postEntities);
      userEntity.setCompanyEntity(companyEntity);
      return userEntity;
    }).collect(Collectors.toList());

    // save all users, posts, companies at the same time
    userRepository.saveAll(userEntities);
  }
}
