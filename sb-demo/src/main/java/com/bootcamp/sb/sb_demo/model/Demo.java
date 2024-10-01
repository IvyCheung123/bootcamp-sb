package com.bootcamp.sb.sb_demo.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Demo {
  @JsonProperty(value = "stringlist")
  private static List<String> strings = new ArrayList<>(List.of("one"));
  
  public static List<String> getStrings() {
    return strings;
  }

  public static String add(String newStr) {
    strings.add(newStr);
    return newStr;
  }

  public static String update(int idx, String newStr) {
    if (idx >= 0 && idx < strings.size()) {
      strings.set(idx, newStr);
    }
    return newStr;
  }
}