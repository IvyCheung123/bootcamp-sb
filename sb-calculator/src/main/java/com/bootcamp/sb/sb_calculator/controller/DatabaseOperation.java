package com.bootcamp.sb.sb_calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface DatabaseOperation {
  // Write Operation (create new resources, e.g. call other API to create) / (insert to db)
  @PostMapping(value = "/database/strings/{newString}")
  String addString(@PathVariable String newString);
  
  // Read Operation (do not perform write operation inside Read Operation)
  @GetMapping(value = "/database/strings/{index}")
  String getString(@PathVariable String index);

  @GetMapping(value = "/database/strings/size")
  int getSize();

  @GetMapping(value = "/database/strings")
  public List<String> getStrings();
}
