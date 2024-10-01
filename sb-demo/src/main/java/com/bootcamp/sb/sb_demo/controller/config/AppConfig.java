package com.bootcamp.sb.sb_demo.controller.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.sb.sb_demo.model.Demo;
import com.bootcamp.sb.sb_demo.model.MyBean;

@Configuration // Component -> Bean = new AppConfig()
public class AppConfig {
  // Create bean with attributes
  @Bean // Bean name by default follow method() name
  com.bootcamp.sb.sb_demo.model.MyBean create() {
    return new MyBean(1);
  }

  @Bean(name = "bean2")
  com.bootcamp.sb.sb_demo.model.MyBean create2() {
   return new MyBean(2);
 }
}
