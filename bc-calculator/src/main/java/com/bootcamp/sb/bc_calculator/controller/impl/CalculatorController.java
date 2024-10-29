package com.bootcamp.sb.bc_calculator.controller.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.bc_calculator.controller.CalculatorOperation;
import com.bootcamp.sb.bc_calculator.model.APIRequest;
import com.bootcamp.sb.bc_calculator.model.APIResponse;
import com.bootcamp.sb.bc_calculator.service.CalculatorService;

@RestController
public class CalculatorController implements CalculatorOperation {
  @Autowired
  private CalculatorService calculatorService;

  @Override
  public APIResponse calculator1(String x, String y, String operation) {
    BigDecimal convertX = BigDecimal.valueOf(Double.valueOf(x));
    BigDecimal convertY = BigDecimal.valueOf(Double.valueOf(y));
    return calculatorService.calculator(convertX, convertY, operation);
  }
  
  @Override
  public APIResponse calculator2(APIRequest apiRequest) {
    BigDecimal convertX = BigDecimal.valueOf(Double.valueOf(apiRequest.getX()));
    BigDecimal convertY = BigDecimal.valueOf(Double.valueOf(apiRequest.getY()));
    return calculatorService.calculator(convertX, convertY, apiRequest.getOperation());
  }

  @Override
  public APIResponse calculator3(String x, String y, String operation) {
    BigDecimal convertX = BigDecimal.valueOf(Double.valueOf(x));
    BigDecimal convertY = BigDecimal.valueOf(Double.valueOf(y));
    return calculatorService.calculator(convertX, convertY, operation);
  }
}
