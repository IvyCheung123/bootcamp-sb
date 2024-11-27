package com.bootcamp.sb.sb_restapi.model.mapping;

import org.springframework.stereotype.Component;
import com.bootcamp.sb.sb_restapi.entity.CompanyEntity;
import com.bootcamp.sb.sb_restapi.entity.PostEntity;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.model.Post;
import com.bootcamp.sb.sb_restapi.model.PostDTO;
import com.bootcamp.sb.sb_restapi.model.User;
import com.bootcamp.sb.sb_restapi.model.UserPostDTO;

@Component // keep instance
public class Mapper {
  public UserEntity map(User user) {
    return UserEntity.builder()
      .name(user.getName())
      .username(user.getUsername())
      .email(user.getEmail())
      .phone(user.getPhone())
      .website(user.getWebsite())
      .build();
  }

  public PostEntity map(Post post) {
    return PostEntity.builder()
      .id(post.getId())
      .title(post.getTitle())
      .body(post.getBody())
      .build();
  }

  public UserPostDTO mapUserToUserPostDTO(User user) {
    return UserPostDTO.builder()
      .userId(user.getId())
      .username(user.getUsername())
      .useremail(user.getEmail())
      .build();
  }

  public PostDTO mapPostToPostDTO(Post post) {
    return PostDTO.builder()
      .userId(post.getUserId())
      .id(post.getId())
      .title(post.getTitle())
      .body(post.getTitle())
      .build();
  }

  public User mapUserEntityToUser(UserEntity userEntity) {
    return User.builder()
      .name(userEntity.getName())
      .username(userEntity.getUsername())
      .email(userEntity.getEmail())
      .phone(userEntity.getPhone())
      .website(userEntity.getWebsite())
      .build();
  }

  public Post mapPostEntityToPost(PostEntity postEntity) {
    return Post.builder()
      .id(postEntity.getId())
      .title(postEntity.getTitle())
      .body(postEntity.getBody())
      .build();
  }

  public CompanyEntity mapUserToCompanyEntity(User.Company company) {
    return CompanyEntity.builder()
      .name(company.getName())
      .catchPhrase(company.getCatchPhrase())
      .bs(company.getBs())
      .build();
  }
}
