package com.bootcamp.sb.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sb.bc_calculator.model.APIRequest;
import com.bootcamp.sb.bc_calculator.model.APIResponse;

public interface CalculatorOperation {
  @GetMapping(value = "/operation")
  APIResponse calculator1(@RequestParam String x, @RequestParam String y, @RequestParam String operation);
  
  @PostMapping(value = "/operation")
  APIResponse calculator2(@RequestBody APIRequest apiRequest);

  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  APIResponse calculator3(@PathVariable String x, @PathVariable String y, @PathVariable String operation);
}
