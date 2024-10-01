package com.bootcamp.sb.sb_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.sb_calculator.controller.CatOperation;
import com.bootcamp.sb.sb_calculator.model.Cat;
import io.micrometer.observation.annotation.Observed;

@Controller
@ResponseBody
public class CatController implements CatOperation {
  @Autowired
  @Qualifier(value = "peter")
  private Cat cat;

  @Override
  public String getCatName() {
    return this.cat.getName();
  }

  @Override
  public Cat updateCatName(String newName) {
    this.cat.setName(newName);
    return this.cat;
  }
}
