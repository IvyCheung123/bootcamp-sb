package com.bootcamp.sb.sb_demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface DemoOperation {
  @GetMapping(value = "/strings")
  public List<String> getStrings();

  @PostMapping(value = "/strings/{newStr}")
  public String add(@PathVariable String newStr);

  @PutMapping(value = "/strings/{idx}/{newStr}")
  public String update(@PathVariable int idx, @PathVariable String newStr);

  @GetMapping(value = "/beans")
  public int getBeanNum();
}
