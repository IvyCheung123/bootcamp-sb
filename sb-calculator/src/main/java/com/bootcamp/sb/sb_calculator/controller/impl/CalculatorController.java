package com.bootcamp.sb.sb_calculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CalculatorController {

  @GetMapping(value = "/sum/{a}/{b}") // @PathVariable int x -> "{x}"
  public int sum(@PathVariable(value = "b") int x, 
    @PathVariable(value = "a") int y) {
      System.out.println("x=" + x + ", y=" + y);
    return x + y;
  }

  // @GetMapping(value = "/subtract/{x}/{y}")
  // public Long subtract(@PathVariable Long x, @PathVariable Long y) { // auto-box
  //     return x - y;
  // }

  @GetMapping(value = "/subtract/{x}/{y}")
  public String subtract(@PathVariable String x, @PathVariable String y) { // auto-box
    try {
      return String.valueOf(Long.parseLong(x) - Long.parseLong(y));
    } catch (NumberFormatException e) {
      return "The input params should be a number";
    }
  }

  @GetMapping(value = "/divide/{x}/{y}")
  public String divide(@PathVariable int x, @PathVariable int y) { // by default use String, and then convert
    try {
      return String.valueOf(x / y);
    } catch (ArithmeticException e) {
      return "Not support / by zero";
    }
  }

  // how to test overflow ?
}
