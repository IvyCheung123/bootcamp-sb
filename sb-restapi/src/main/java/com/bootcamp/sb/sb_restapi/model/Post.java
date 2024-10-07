package com.bootcamp.sb.sb_restapi.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Post {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
