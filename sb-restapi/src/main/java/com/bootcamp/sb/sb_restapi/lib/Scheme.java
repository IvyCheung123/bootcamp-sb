package com.bootcamp.sb.sb_restapi.lib;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTP("http://"),
  HTTPS("https://"),
  ;

  private String urlPrefix;

  private Scheme(String urlPrefix) {
    this.urlPrefix = urlPrefix;
  }
}
