package com.bootcamp.sb.sb_calculator.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.sb_calculator.controller.DatabaseOperation;
import com.bootcamp.sb.sb_calculator.model.Database;
import com.bootcamp.sb.sb_calculator.service.DatabaseService;

// Controller -> Service -> Database
@Controller
@ResponseBody
public class DatabaseController implements DatabaseOperation {
  @Autowired
  private DatabaseService databaseService;

  // Constructor injection -> similar to above
  // @Autowired
  // public DatabaseController(DatabaseService databaseService) {
  //   this.databaseService = databaseService;
  // }

  @Override
  public String addString(String newString) {
    return databaseService.addString(newString);
  }

  // @Override
  // public String getString(int index) {
  //   return databaseService.getString(index);
  // }

  @Override
  public String getString(String index) {
    boolean isIndexValid = true;
    int idx = -1;
    try {
      idx = Integer.valueOf(index);
    } catch (NumberFormatException e) {
      isIndexValid = false;
    }
    if (idx < 0 || idx > Database.size() - 1) {
      isIndexValid = false;
    }
    return isIndexValid ? databaseService.getString(idx) : "Invalid input";
  }

  @Override
  public int getSize() {
    return databaseService.getStringsSize();
  }

  @Override
  public List<String> getStrings() {
    return Arrays.stream(databaseService.getStrings())
      .collect(Collectors.toList());
  }
}
