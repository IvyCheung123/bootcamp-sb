package com.bootcamp.sb.sb_restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.sb.sb_restapi.lib.RedisHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration // can create many bean for this class
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) {
    return new RedisHelper(redisConnectionFactory, objectMapper);
  }

  @Bean // Thread-safe ???
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
