package com.bootcamp.sb.sb_restapi;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.service.UserService;

// @SpringBootTest // Full scale of SpringContext
@WebMvcTest // A test spring environment, consist of web related (controller) beans + some other beans for test (e.g. MockMvc)
public class UserControllerTest {
  // @Autowired
  // private UserController userController;

  // @MockBean -> UserService since Controller depends on Service

  @Autowired
  private MockMvc mockMvc; // similar to Postman

  @MockBean
  private UserService userService;

  // @WebMvcTest(controllers = (BankUserController.class))
  // In order to create the bean of BankUserController for this testing environment
  // BankMapper bean is required
  // so we have to add the BankMapper explicitly
  // @SpyBean
  // private BankMapper bankMapper;

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
  void testGetUserByUsername() throws Exception {
    // Postman -> URL -> Spring Boot Controller -> Service
    // Spring Web contains Mockito, no need to inject dependency

    // Assumption
    UserEntity userEntity = UserEntity.builder()
      .name("Betty")
      .website("betty.com")
      .build();
    Mockito.when(userService.getUserByUsername("John")).thenReturn(userEntity);
  
  // Test
  // this.mockMvc.perform(MockMvcRequestBuilders.get("/user").param("username", "John"))
  //   .andExpect(MockMvcResultMatchers.status().isOk())
  //   .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000000")))
  //   .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Success"))) // Matchers.is() -> calling String.equals()
  //   .andExpect(MockMvcResultMatchers.jsonPath("$.data.[*].name").value(Matchers.hasItem("Betty")))
  //   .andExpect(MockMvcResultMatchers.jsonPath("$.data.[*].website").value(Matchers.hasItem("betty.com")));

  this.mockMvc.perform(get("/getUserByUsername").param("username", "John"))
  // post("/")? pathVariable?
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.code", is("000000")))
    .andExpect(jsonPath("$.message", is("Success"))) // Matchers.is() -> calling String.equals()
    .andExpect(jsonPath("$.data.[*].name").value(hasItem("Betty")))
    .andExpect(jsonPath("$.data.[*].website").value(hasItem("betty.com")));
  }
}
