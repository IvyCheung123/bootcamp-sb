package com.bootcamp.sb.bc_calculator.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.bootcamp.sb.bc_calculator.exception.InvalidOperatorException;
import com.bootcamp.sb.bc_calculator.infra.ErrorCode;
import com.bootcamp.sb.bc_calculator.infra.Operation;
import com.bootcamp.sb.bc_calculator.model.APIRequest;
import com.bootcamp.sb.bc_calculator.model.APIResponse;
import com.bootcamp.sb.bc_calculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {
  @Override
  public APIResponse calculator(BigDecimal x, BigDecimal y, String operation) {
    Operation op = this.map(operation);
    return APIResponse.builder()
      .x(String.valueOf(x))
      .y(String.valueOf(y))
      .operation(op.getOperator())
      .result(op.calculate(x, y))
      .build();
  }
  
  // @Override
  // public APIResponse calculator2(APIRequest apiRequest) {
  //   Operation op = this.map(apiRequest.getOperation());
  //   BigDecimal x = BigDecimal.valueOf(Double.valueOf(apiRequest.getX()));
  //   BigDecimal y = BigDecimal.valueOf(Double.valueOf(apiRequest.getY()));
  //   return APIResponse.builder()
  //     .x(String.valueOf(apiRequest.getX()))
  //     .y(String.valueOf(apiRequest.getY()))
  //     .operation(op.getOperator())
  //     .result(op.calculate(x, y))
  //     .build();
  // }

  // @Override
  // public APIResponse calculator3(BigDecimal x, BigDecimal y, String operation) {
  //   Operation op = this.map(operation);
  //   return APIResponse.builder()
  //     .x(String.valueOf(x))
  //     .y(String.valueOf(y))
  //     .operation(op.getOperator())
  //     .result(op.calculate(x, y))
  //     .build();
  // }

  private Operation map(String operator) {
    for (Operation op : Operation.values()) { // Enum.values() return Enum[]
      if (op.getOperator().equals(operator)) {
        return op;
      }
    }
    throw new InvalidOperatorException(ErrorCode.INVALID_OPERATOR.getMessage());
  }
}
