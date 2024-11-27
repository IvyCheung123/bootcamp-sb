package com.bootcamp.sb.sb_aws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // return static html page
@RequestMapping("/web")
public class WebController {
  // 1. Client call getMapping
  // 2. Go to templates "say.html" to look for variable "message"
  // 3. Put "message" to model.addAttribute("message", "Hello World");
  @GetMapping("/hello")
  public String sayHello(Model model) { // Model is @Bean
    // Call DB -> return String
    // model.addAttribute("message", DB);
    model.addAttribute("message", "Hello World");
    return "say"; // say.html
  }
}
