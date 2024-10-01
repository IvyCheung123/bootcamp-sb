package com.bootcamp.sb.sb_calculator.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.sb.sb_calculator.model.Cat;

@Configuration // Component
public class AppConfig { // new AppConfig()
  // create bean with status

  // @Configuration + @Bean
  @Bean(name = "john") // name by default follow method() name
  Cat createCat() {
    return new Cat("John");
  }

  @Bean(name = "peter")
  Cat createCat2() {
    return new Cat("Peter");
  }
}
