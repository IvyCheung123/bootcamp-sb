package com.bootcamp.sb.sb_demo.controller.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.sb_demo.controller.DemoOperation;
import com.bootcamp.sb.sb_demo.model.Demo;
import com.bootcamp.sb.sb_demo.model.MyBean;
import com.bootcamp.sb.sb_demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@ResponseBody
public class DemoController implements DemoOperation {
  @Autowired
  private DemoService demoService;

  @Autowired
  @Qualifier(value = "bean2")
  private MyBean myBean;

  @Override
  public List<String> getStrings() {
    return demoService.getStrings();
  }

  @Override
  public String add(@PathVariable String newStr) {
    return demoService.add(newStr);
  }

  @Override
  public String update(@PathVariable int idx, @PathVariable String newStr) {
    return demoService.update(idx, newStr);
  }

  @Override
  public int getBeanNum() {
    return this.myBean.getBeanNum();
  }
}
