package com.bootcamp.sb.sb_calculator.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  private int id;
  private double price;
  private List<String> strings; // dummy data
}
