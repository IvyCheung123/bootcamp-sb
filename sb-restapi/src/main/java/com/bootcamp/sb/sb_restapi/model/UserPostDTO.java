package com.bootcamp.sb.sb_restapi.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPostDTO {
  private Long userId;
  private String username;
  private String useremail;
  private List<PostDTO> postDTO;
}
