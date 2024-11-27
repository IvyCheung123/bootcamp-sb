package com.bootcamp.sb.sb_aws.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bootcamp.sb.sb_aws.model.Coin;
import com.bootcamp.sb.sb_aws.service.CoinService;

@Controller
@RequestMapping("/web")
public class CoinController {
  @Autowired
  private CoinService coinService;

  @GetMapping("/coin")
  public String getCoins(Model model) {
    List<Coin> coins = this.coinService.getCoin();
    model.addAttribute("coinList", coins);
    return "coin"; // return coin.html
  }
}
