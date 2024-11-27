package com.bootcamp.sb.sb_aws.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/sb/aws")
public class HelloController {
  @GetMapping("/hello/{str}")
  public String sayHello(@PathVariable String str) {
      return "helloworld";
  }
}
