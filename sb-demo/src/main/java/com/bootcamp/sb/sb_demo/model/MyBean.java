package com.bootcamp.sb.sb_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyBean {
  private int num;

  public int getBeanNum() {
    return this.num;
  }
}
