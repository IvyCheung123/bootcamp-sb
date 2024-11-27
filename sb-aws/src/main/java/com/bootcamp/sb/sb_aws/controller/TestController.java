package com.bootcamp.sb.sb_aws.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bootcamp.sb.sb_aws.model.Coin;

@Controller
@RequestMapping("/web")
public class TestController {
  @GetMapping("/cointest")
  public List<Coin> getFakeCoins() {
    return Arrays.asList();
  }
}
