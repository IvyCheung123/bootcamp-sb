package com.bootcamp.sb.sb_restapi.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
  private int code;
  private String message;
}
