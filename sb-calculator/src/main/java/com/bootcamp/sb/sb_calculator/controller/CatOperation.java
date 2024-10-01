package com.bootcamp.sb.sb_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import com.bootcamp.sb.sb_calculator.model.Cat;

public interface CatOperation {
  @GetMapping(value = "/cat")
  String getCatName();

  // Update resource
  @PutMapping(value = "/cat/{newName}")
  Cat updateCatName(@PathVariable String newName);
}
