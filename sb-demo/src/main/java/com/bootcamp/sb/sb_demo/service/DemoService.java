package com.bootcamp.sb.sb_demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.sb.sb_demo.controller.config.AppConfig;
import com.bootcamp.sb.sb_demo.model.Demo;

@Service
public class DemoService {
  public List<String> getStrings() {
    return Demo.getStrings();
  }

  public String add(String newStr) {
    return Demo.add(newStr);
  }

  public String update(int idx, String newStr) {
    return Demo.update(idx, newStr);
  }
}
