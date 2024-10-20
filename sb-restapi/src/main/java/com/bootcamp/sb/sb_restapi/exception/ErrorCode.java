package com.bootcamp.sb.sb_restapi.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_ID_NOT_FOUND_EXCEPTION(1, "User ID Not Found Exception"),
    BUSINESS_EXCEPTION(2, "Business Exception"),
    ;

    private int code;
    private String message;

    private ErrorCode(int code, String message) {
      this.code = code;
      this.message = message;
    }
}
