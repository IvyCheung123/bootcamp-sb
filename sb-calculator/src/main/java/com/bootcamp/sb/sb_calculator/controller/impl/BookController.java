package com.bootcamp.sb.sb_calculator.controller.impl;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.sb_calculator.controller.BookOperation;
import com.bootcamp.sb.sb_calculator.model.Bag;
import com.bootcamp.sb.sb_calculator.model.Book;
import com.bootcamp.sb.sb_calculator.model.Bag.Color;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // bean
// mvn spring-boot:run will perform ComponentScan
// @Controller annotation -> before server start completed -> new BookController()
// The created object -> Spring Context (not heap memory, is separated memory location)
// All this kind of objects is bean
// This bean must be created before server start completed
// Implication: If the bean fail to create, server start fails. If the bean not exist, server start fails, no API services (request)

// Spring Context -> shared same object with Agent
// instance method need to new BookController()
@ResponseBody
public class BookController implements BookOperation {
  // http://localhost:8080/book/1/10.3
  // @GetMapping(value = "/book/{id}/{price}")
  // public Book getBook(@PathVariable int id, @PathVariable double price) {
  // return new Book(id, price);
  // }

  // http://localhost:8080/book?id=1&price=10.3
  // http://localhost:8080/book?a=1&b=10.3
  // @GetMapping(value = "/book")
  // public Book getBook2(@RequestParam(value = "a") int id, @RequestParam(value = "b") double price) {
  // return new Book(id, price);
  // }

  // @GetMapping(value = "/booklist")
  // public List<Book> getBookList() {
  // return List.of(new Book(1, 10.3), new Book(2, 99.9));
  // }

  // @GetMapping(value = "/bookset")
  // public Set<Book> getBookSet() {
  // return Set.of(new Book(1, 10.3), new Book(2, 99.9)); // but cannot put duplicate
  // // if duplicate, use add
  // }

  // @GetMapping(value = "/bookmap")
  // public Map<String, Book> getBookMap() {
  // Map<String, Book> bookMap = new HashMap<>();
  // bookMap.put("Book 1", new Book(1, 10.3));
  // bookMap.put("Book 2", new Book(2, 99.9));
  // return bookMap;
  // }

  // @GetMapping(value = "/bookarray")
  // public Book[] getBookArray() {
  // return new Book[] {new Book(1, 10.3), new Book(2, 99.9)};
  // }

  public Book getBook(int id, double price) {
    return new Book(id, price, null);
  }

  public Book getBook2(int id, double price) {
    return new Book(id, price, null);
  }

  public List<Book> getBookList() {
    return List.of(new Book(1, 10.3, null), new Book(2, 99.9, null));
  }

  public Set<Book> getBookSet() {
    return Set.of(new Book(1, 10.3, null), new Book(2, 99.9, null)); // but cannot put duplicate
    // if duplicate, use add
  }

  public Map<String, Book> getBookMap() {
    Map<String, Book> bookMap = new HashMap<>();
    bookMap.put("Book 1", new Book(1, 10.3, null));
    bookMap.put("Book 2", new Book(2, 99.9, null));
    return bookMap;
  }

  public Book[] getBookArray() {
    return new Book[] {new Book(1, 10.3, null), new Book(2, 99.9, null)};
  }

  public Bag getBag() {
    return Bag.builder()
        .books(List.of(new Book(1, 10.3, List.of("abc", "def")),
            new Book(2, 99.9, List.of("xyz"))))
        .color(Color.RED).build();
  }
}
