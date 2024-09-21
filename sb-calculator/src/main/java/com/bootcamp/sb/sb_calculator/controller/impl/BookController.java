package com.bootcamp.sb.sb_calculator.controller.impl;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.sb_calculator.controller.BookOperation;
import com.bootcamp.sb.sb_calculator.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class BookController implements BookOperation {
  // http://localhost:8080/book/1/10.3
  // @GetMapping(value = "/book/{id}/{price}")
  // public Book getBook(@PathVariable int id, @PathVariable double price) {
  //   return new Book(id, price);
  // }

  // // http://localhost:8080/book?id=1&price=10.3
  // // http://localhost:8080/book?a=1&b=10.3
  // @GetMapping(value = "/book")
  // public Book getBook2(@RequestParam(value = "a") int id, @RequestParam(value = "b") double price) {
  //   return new Book(id, price);
  // }

  // @GetMapping(value = "/booklist")
  // public List<Book> getBookList() {
  //   return List.of(new Book(1, 10.3), new Book(2, 99.9));
  // }

  // @GetMapping(value = "/bookset")
  // public Set<Book> getBookSet() {
  //   return Set.of(new Book(1, 10.3), new Book(2, 99.9)); // but cannot put duplicate
  //   // if duplicate, use add
  // }

  // @GetMapping(value = "/bookmap")
  // public Map<String, Book> getBookMap() {
  //   Map<String, Book> bookMap = new HashMap<>();
  //   bookMap.put("Book 1", new Book(1, 10.3));
  //   bookMap.put("Book 2", new Book(2, 99.9));
  //   return bookMap;
  // }

  // @GetMapping(value = "/bookarray")
  // public Book[] getBookArray() {
  //   return new Book[] {new Book(1, 10.3), new Book(2, 99.9)};
  // }

  public Book getBook(int id, double price) {
    return new Book(id, price);
  }

  public Book getBook2(int id, double price) {
    return new Book(id, price);
  }

  public List<Book> getBookList() {
    return List.of(new Book(1, 10.3), new Book(2, 99.9));
  }

  public Set<Book> getBookSet() {
    return Set.of(new Book(1, 10.3), new Book(2, 99.9)); // but cannot put duplicate
    // if duplicate, use add
  }

  public Map<String, Book> getBookMap() {
    Map<String, Book> bookMap = new HashMap<>();
    bookMap.put("Book 1", new Book(1, 10.3));
    bookMap.put("Book 2", new Book(2, 99.9));
    return bookMap;
  }

  public Book[] getBookArray() {
    return new Book[] {new Book(1, 10.3), new Book(2, 99.9)};
  }
}
