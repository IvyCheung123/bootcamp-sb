package com.bootcamp.sb.sb_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NewPost {
  private Long userId;
  private String title;
  private String body;
}
