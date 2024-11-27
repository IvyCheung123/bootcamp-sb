package com.bootcamp.sb.sb_aws.infra;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
  @Override
  public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      // JSON -> LocalDateTime
      String date = p.getText();
      // Instant instant = Instant.parse(date); // .parse() -> GlobalExceptionHandler
      // ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Hong_Kong"));
      // return zonedDateTime.toLocalDateTime();
      LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
      return localDateTime.atOffset(ZoneOffset.UTC).withOffsetSameInstant(ZoneOffset.ofHours(8)).toLocalDateTime();
  }
}
