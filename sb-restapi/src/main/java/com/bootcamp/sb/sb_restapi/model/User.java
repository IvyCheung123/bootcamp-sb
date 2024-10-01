package com.bootcamp.sb.sb_restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter // serialization
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private int id;
  private String name;
  private String username;
  private String email;
  private Address adress;
  private String phone;
  private String website;
  private Company company;

  private class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    private class Geo {
      private String lat;
      private String lng;
    }
  }

  private class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
