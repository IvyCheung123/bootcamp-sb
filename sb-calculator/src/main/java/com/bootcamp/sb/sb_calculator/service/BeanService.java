package com.bootcamp.sb.sb_calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bootcamp.sb.sb_calculator.SbCalculatorApplication;

@Service
public class BeanService {
  public List<String> getBeans() {
    return Arrays.stream(SbCalculatorApplication.springContext.getBeanDefinitionNames())
      .collect(Collectors.toList());
  }
}
