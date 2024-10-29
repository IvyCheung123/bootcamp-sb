package com.bootcamp.sb.bc_calculator.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.sb.bc_calculator.infra.ErrorCode;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = CannotDivideZeroException.class)
  public ErrorResponse cannotDivideZeroException() {
    return ErrorResponse.builder()
      .code(ErrorCode.CANNOT_DIVIDE_ZERO.getCode())
      .message(ErrorCode.CANNOT_DIVIDE_ZERO.getMessage())
      .build();
  }

  @ExceptionHandler(value = InvalidOperatorException.class)
  public ErrorResponse invalidOperatorException() {
    return ErrorResponse.builder()
      .code(ErrorCode.INVALID_OPERATOR.getCode())
      .message(ErrorCode.INVALID_OPERATOR.getMessage())
      .build();
  }

  @ExceptionHandler(value = RuntimeException.class)
  public ErrorResponse catchRuntimeException() {
    return ErrorResponse.builder()
      .code(ErrorCode.INVALID_INPUT.getCode())
      .message(ErrorCode.INVALID_INPUT.getMessage())
      .build();
  }

  @ExceptionHandler(value = Exception.class)
  public ErrorResponse catchException() {
    return ErrorResponse.builder()
      .code(ErrorCode.INVALID_INPUT.getCode())
      .message(ErrorCode.INVALID_INPUT.getMessage())
      .build();
  }
}
