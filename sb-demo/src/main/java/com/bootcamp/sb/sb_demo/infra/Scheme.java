package com.bootcamp.sb.sb_demo.infra;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTP("http"),
  HTTPS("https"),
  ;

  private String protocol;

  private Scheme(String protocol) {
    this.protocol = protocol;
  }
}
