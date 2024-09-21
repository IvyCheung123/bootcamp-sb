package com.bootcamp.sb.sb_calculator.controller;

import java.util.List;
import java.util.Set;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sb.sb_calculator.model.Book;

public interface BookOperation {
  @GetMapping(value = "/book/{id}/{price}")
  public Book getBook(@PathVariable int id, @PathVariable double price);

  @GetMapping(value = "/book")
  public Book getBook2(@RequestParam(value = "a") int id, @RequestParam(value = "b") double price);

  @GetMapping(value = "/booklist")
  public List<Book> getBookList();

  @GetMapping(value = "/bookset")
  public Set<Book> getBookSet();

  @GetMapping(value = "/bookmap")
  public Map<String, Book> getBookMap();

  @GetMapping(value = "/bookarray")
  public Book[] getBookArray();
}
