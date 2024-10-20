package com.bootcamp.sb.sb_restapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 1. Happy: Controller -> Method A -> Method B -> Method C -> return object to B -> return object to A
// 2. Unhappy: Controller -> Method A -> Method B -> Method C -> throw exception -> B handle exception (try-catch each time) ...
// 3. Happy: Controller -> Method A -> Method B -> Method C -> throw exception -> GlobalExceptionHandler -> do not try-catch in B
@RestControllerAdvice
public class GlobalExceptionHandler {
  // try to catch BusinessException
  @ExceptionHandler(BusinessException.class)
  public ErrorResponse businessExceptionHandler(BusinessException e) {
    return ErrorResponse.builder()
      .code(e.getCode())
      .message(e.getMessage())
      .build();
  } // you throw -> agent will bring this throw to here for handling

  // @ExceptionHandler(BusinessException.class)
  // public ErrorResponse businessExceptionHandler() {
  //   return ErrorResponse.builder()
  //     .code(ErrorCode.BUSINESS_EXCEPTION.getCode())
  //     .message(ErrorCode.BUSINESS_EXCEPTION.getMessage())
  //     .build();
  // }

  @ExceptionHandler(UserIdNotFoundException.class)
  public ErrorResponse userIdNotFoundExceptionHandler() {
    return ErrorResponse.builder()
      .code(ErrorCode.USER_ID_NOT_FOUND_EXCEPTION.getCode())
      .message(ErrorCode.USER_ID_NOT_FOUND_EXCEPTION.getMessage())
      .build();
  }

  // 包底 e.g. Exception in RestTemplate
  @ExceptionHandler(Exception.class)
  public ErrorResponse userIdNotFoundExceptionHandler(ErrorCode errorCode) {
    return ErrorResponse.builder()
      .code(errorCode.getCode())
      .message(errorCode.getMessage())
      .build();
  }
}
