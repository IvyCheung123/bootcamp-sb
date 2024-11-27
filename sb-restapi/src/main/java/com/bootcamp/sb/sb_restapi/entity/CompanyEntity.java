package com.bootcamp.sb.sb_restapi.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Companies")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String catchPhrase;
  private String bs;

  @OneToOne
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;
}
