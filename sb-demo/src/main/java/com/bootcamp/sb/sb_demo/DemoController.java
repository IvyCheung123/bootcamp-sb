package com.bootcamp.sb.sb_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ResponseBody
public class DemoController {
  @GetMapping(value = "/v1/demo")
  public String greeting() {
    return "Hello World";
  }
}
