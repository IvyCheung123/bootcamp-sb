package com.bootcamp.sb.sb_aws.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.sb.sb_aws.model.Coin;
import com.bootcamp.sb.sb_aws.service.CoinService;

@Service
public class CoinImpl implements CoinService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Coin> getCoin() {
    String url = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    return Arrays.asList(this.restTemplate.getForObject(url, Coin[].class));
  }
}
