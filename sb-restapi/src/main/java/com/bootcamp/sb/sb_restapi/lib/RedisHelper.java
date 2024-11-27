package com.bootcamp.sb.sb_restapi.lib;

import java.time.Duration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisHelper {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;

  public RedisHelper(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) {
    this.redisTemplate = new RedisTemplate<>();
    this.redisTemplate.setConnectionFactory(redisConnectionFactory);
    this.redisTemplate.setKeySerializer(RedisSerializer.string());
    this.redisTemplate.setValueSerializer(RedisSerializer.json());
    this.redisTemplate.afterPropertiesSet();
    this.objectMapper = objectMapper;
  }

  public <T> void set(String key, T object) throws JsonProcessingException {
    String jsonToWrite = this.objectMapper.writeValueAsString(object);
    this.redisTemplate.opsForValue().set(key, jsonToWrite);
  }

  public <T> void set(String key, T object, Duration duration) throws JsonProcessingException {
    String jsonToWrite = this.objectMapper.writeValueAsString(object);
    this.redisTemplate.opsForValue().set(key, jsonToWrite, duration);
  }

  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException {
    String json = this.redisTemplate.opsForValue().get(key);
    return this.objectMapper.readValue(json, clazz);
  }
}
