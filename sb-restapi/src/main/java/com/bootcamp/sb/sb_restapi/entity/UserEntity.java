package com.bootcamp.sb.sb_restapi.entity;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // JPA
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Hibernate -> @Entity
@Entity // JPA creates table if table not exists in database
@Table(name = "Users")
@Getter
@Setter // SaveDataRunner
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
  @Id // Primary Key // import jakarta.persistence.Id; // JPA
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
  @Column(name = "userId")
  private Long id; // Primary key, Long -> BIGINT
  private String name;
  @NotNull
  private String username;
  @Column(name = "useremail") // by default follow attribute name
  private String email;
  private String phone;
  private String website;

  // ALL = REMOVE + PERSIST + MERGE
  // REMOVE: delete user -> delete all posts by user at the same time
  // PERSIST: insert at the same time
  // MERGE: update at the same time

  // LAZY (by default): select * from users -> (select * from posts) when use only
  
  @Builder.Default
  @OneToMany(mappedBy = "userEntity", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
  private List<PostEntity> postEntities = new ArrayList<>();;

  @OneToOne(mappedBy = "userEntity", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private CompanyEntity companyEntity;
}
