package com.bootcamp.sb.sb_calculator.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingMall {
  private String name;
  private int area;
  private Cinema cinema;
  private List<String> shopCategory;

  private static class Cinema {
    private String name;
    private LocalDate openedDate;
    private List<ReleasedFilm> releasedFilms;

    private static class ReleasedFilm {
      private String name;
      private LocalDate releaseDate;
    }
  }
}
