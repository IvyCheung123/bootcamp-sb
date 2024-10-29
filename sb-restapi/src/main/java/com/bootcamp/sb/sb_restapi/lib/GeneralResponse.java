package com.bootcamp.sb.sb_restapi.lib;

import java.util.ArrayList;
import java.util.List;
import com.bootcamp.sb.sb_restapi.model.User;

// See README.md
// Don't use Lombok
public class GeneralResponse<T> { // ApiResponse
  private String code;
  private String message;
  private List<T> data;

  // static method <U>
  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  private GeneralResponse(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T> getData() {
    return this.data;
  }

  @Override
  public String toString() {
    return "GeneralResponse("
    + "code=" + this.code
    + ", message=" +this.message
    + ", data=" + this.data
    + ")";
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private List<T> data;

    public Builder<T> status(SysCode sysCode) {
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      if (sysCode == SysCode.FAIL) {
        this.data = new ArrayList<>(); // // empty[] but not null
      }
      return this;
    }

    // public Builder<T> code(String code) {
    //   this.code = code;
    //   return this;
    // }

    // public Builder<T> message(String message) {
    //   this.message = message;
    //   return this;
    // }

    public Builder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public GeneralResponse<T> build() {
      if (this.code == null || this.message == null) {
        throw new IllegalArgumentException("Missing code and message.");
      }
      return new GeneralResponse<>(this); //inner class call outer class constructor
    }
  }

  public static void main(String[] args) {
    GeneralResponse<User> generalResponse = GeneralResponse.<User>builder() // define type of static method with Generic
      .status(SysCode.OK)
      .data(List.of(new User()))
      .build();

    System.out.println(generalResponse);
  }
}
