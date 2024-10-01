package com.bootcamp.sb.sb_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// 1. @SpringBootConfiguration
// 2. @EnableAutoConfiguration
// 3. @ComponentScan
	// What is Bean?
	// The object lifecycle is managed by someone, but not you
	// In Spring, most of the bean are created during server start
	// What is Component?
	// A class that used to create bean is component (e.g. @Controller)
public class SbCalculatorApplication {
	public static ConfigurableApplicationContext springContext;

	public static void main(String[] args) {
		// static method
		SbCalculatorApplication.springContext = 
			SpringApplication.run(SbCalculatorApplication.class, args);
	}

}
