package com.bootcamp.sb.bc_calculator.service;

import java.math.BigDecimal;
import com.bootcamp.sb.bc_calculator.model.APIRequest;
import com.bootcamp.sb.bc_calculator.model.APIResponse;

public interface CalculatorService {
  APIResponse calculator(BigDecimal x, BigDecimal y, String operation);
  
  // APIResponse calculator2(APIRequest apiRequest);

  // APIResponse calculator3(BigDecimal x, BigDecimal y, String operation);
}
