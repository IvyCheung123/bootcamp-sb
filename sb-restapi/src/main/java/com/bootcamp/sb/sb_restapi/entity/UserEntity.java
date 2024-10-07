package com.bootcamp.sb.sb_restapi.entity;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // JPA
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // JPA creates table if table not exists in database
@Table(name = "Users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
  private Long id; // Primary key
  private String name;
  private String username;
  @Column(name = "useremail") // by default follow attribute name
  private String email;
  private String phone;
  private String website;
}
