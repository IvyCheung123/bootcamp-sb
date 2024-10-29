package com.bootcamp.sb.sb_restapi;

import java.util.Optional;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.sb.sb_restapi.controller.impl.UserController;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.lib.SysCode;
import com.bootcamp.sb.sb_restapi.service.UserService;

// @SpringBootTest // Full scale of SpringContext
@WebMvcTest // A test spring environment, consist of web related beans + some other beans for test (e.g. MockMvc)
public class UserControllerTest {
  // @Autowired
  // private UserController userController;

  // @MockBean -> UserService since Controller depends on Service

  @Autowired
  private MockMvc mockMvc; // similar to Postman

  @MockBean
  private UserService userService;

  /*
   * public UserEntity getUserFromDBById(@PathVariable Long id) {
   *   Optional<UserEntity> userEntity = this.userService.getUserFromDBById(id);
   *   this.userService.methodB();
   *   this.userService.methodC();
   * }
   * -> @SpyBean -> 拎真野放SpringContext
   * -> can Override methodB(), methodC()
   */

  @Test
  void testGetUserFromDBById() throws Exception {
    // Postman -> URL -> Spring Boot Controller -> Service
    // Spring Web contains Mockito, no need to inject dependency

    // Assumption
    UserEntity userEntity = UserEntity.builder()
      .name("Betty")
      .website("betty.com")
      .build();
    Mockito.when(userService.getUserByUsername("John").thenReturn(userEntity));
  
  // Test
  this.mockMvc.perform(MockMvcRequestBuilders.get("/user").param("username", "John"))
  // post("/")? pathVariable?
    .andExpect(MockMvcResultMatchers.status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000000")))
    .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Success"))) // Matchers.is() -> calling String.equals()
    .andExpect(MockMvcResultMatchers.jsonPath("$.data.[*].name").value(Matchers.hasItem("Betty")))
    .andExpect(MockMvcResultMatchers.jsonPath("$.data.[*].website").value(Matchers.hasItem("betty.com")));
  }
}
