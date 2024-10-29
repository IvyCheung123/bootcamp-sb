package com.bootcamp.sb.sb_restapi.exception;

import com.bootcamp.sb.sb_restapi.lib.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  private int code;

  public BusinessException(ErrorCode errorCode) {
    this(errorCode.getCode(), errorCode.getMessage());
  }

  private BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }
}
