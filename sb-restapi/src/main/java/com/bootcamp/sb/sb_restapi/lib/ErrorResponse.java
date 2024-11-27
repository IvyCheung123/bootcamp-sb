package com.bootcamp.sb.sb_restapi.lib;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
  private int code;
  private String message;
}
