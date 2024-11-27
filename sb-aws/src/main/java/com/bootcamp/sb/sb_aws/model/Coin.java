package com.bootcamp.sb.sb_aws.model;

import java.time.LocalDateTime;
import com.bootcamp.sb.sb_aws.infra.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Coin {
  private String id;
  private String symbol;
  private String name;
  private String image;

  @JsonProperty("current_price")
  private Double currentPrice;

  @JsonProperty("market_cap")
  private Long marketCap;

  @JsonProperty("last_updated")
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime lastUpdated; // String -> LocalDateTime, then UTC -> UTC+8

  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercentage24h; // use Class (Wrapper) to perform deserialization
}
