package com.bootcamp.sb.sb_restapi.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "postID") // nativeQuery
  private Long id;
  private String title;
  private String body;

  // nullable = false -> FK cannot be null (by default true)
  // nullable = true -> must REMOVE
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false) // FK column
  private UserEntity userEntity; // refer to UserEntity
}
