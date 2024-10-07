package com.bootcamp.sb.sb_restapi.lib;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class UrlManager {
  private Scheme scheme;
  private String domain;
  private String endpoint;

  @Override
  public String toString() {
    return this.scheme.getUrlPrefix().concat(this.domain).concat(this.endpoint);
  }
}
