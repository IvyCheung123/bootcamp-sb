package com.bootcamp.sb.sb_restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Posts")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
  private Long userId;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "postID") // nativeQuery
  private Long id;
  private String title;
  private String body;
}
