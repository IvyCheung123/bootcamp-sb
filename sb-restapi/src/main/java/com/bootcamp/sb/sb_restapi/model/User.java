package com.bootcamp.sb.sb_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
public class User {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  // One-to-one
  @Getter
  private static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    private static class Geo {
      private String lat;
      private String lng;
    }
  }

  // One-to-one
  @Getter
  private static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
