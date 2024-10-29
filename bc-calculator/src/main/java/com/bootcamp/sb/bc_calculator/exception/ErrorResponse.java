package com.bootcamp.sb.bc_calculator.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
  private Integer code;
  private String message;
}
