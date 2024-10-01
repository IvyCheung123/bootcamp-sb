package com.bootcamp.sb.sb_calculator.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter // java return object -> agent call getter to get object -> through api path to match 
// @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bag {
  @JsonProperty(value = "booklist")
  private List<Book> books;
  private Color color;

  public static enum Color {
    RED, YELLOW, BLUE,;
  }
}
