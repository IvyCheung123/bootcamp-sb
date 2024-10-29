package com.bootcamp.sb.sb_demo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  @Builder
  static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
  }

  @Getter
  @Builder
  static class Geo {
    private String lat;
    private String lng;
  }

  @Getter
  @Builder
  static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
