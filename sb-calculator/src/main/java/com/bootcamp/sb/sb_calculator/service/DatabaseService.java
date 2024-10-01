package com.bootcamp.sb.sb_calculator.service;

import org.springframework.stereotype.Service;
import com.bootcamp.sb.sb_calculator.model.Database;

@Service // Component -> Bean -> no need to keep create new object -> similar to static
public class DatabaseService {
  public String addString(String newString) {
    return Database.addString(newString);
  }
  
  public String getString(int index) {
    return Database.getString(index);
  }

  public String[] getStrings() {
    return Database.getStrings();
  }

  public int getStringsSize() {
    return Database.size();
  }
}
