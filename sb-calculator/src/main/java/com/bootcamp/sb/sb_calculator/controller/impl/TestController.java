package com.bootcamp.sb.sb_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.sb_calculator.model.Book;

/*
 * @Controller + @Autowired:
 * Spring will help validate if there is a bean for BookController
 * If yes, Spring create TestController bean
 * If no, the above validation fail, so server start fails
 */
@Controller // bean -> new TestController -> can get object
@ResponseBody
public class TestController {
  // 1. Field Injection
  // @Autowired -> must have BookController object -> 先可以 @Controller TestController
  // @Autowired // inject bookController object from Spring Context into this obj ref
  private BookController bookController; // obj ref

  // 2. Constructor Injection
  @Autowired // -> by default have
  public TestController(BookController bookController) {
    this.bookController = bookController;
  }
  // new TestController(bookController)
  // bookController object is from Spring Context

  @GetMapping(value = "/test")
  public Book getBook() {
      return bookController.getBook(99, 100.9); // if no @Autowired, bookController is NPE, not new
  }
  
}
