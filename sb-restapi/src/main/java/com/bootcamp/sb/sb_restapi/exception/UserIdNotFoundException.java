package com.bootcamp.sb.sb_restapi.exception;

import lombok.Getter;

@Getter
public class UserIdNotFoundException extends RuntimeException {
  private int code;

  public UserIdNotFoundException(ErrorCode errorCode) {
    this(errorCode.getCode(), errorCode.getMessage());
  }

  private UserIdNotFoundException(int code, String message) {
    super(message);
    this.code = code;
  }
}
