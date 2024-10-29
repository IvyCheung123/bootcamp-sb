package com.bootcamp.sb.sb_restapi;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bootcamp.sb.sb_restapi.entity.UserEntity;
import com.bootcamp.sb.sb_restapi.repository.UserRepository;
import com.bootcamp.sb.sb_restapi.service.UserService;

// Real Service bean -> call Mocked Repository bean
@SpringBootTest // 要有server start出黎嘅Service Bean，所以用full scale
public class UserServiceTest {
  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Test
  void testGetUserByUsername() {
    UserEntity userEntity = UserEntity.builder()
      .name("Betty")
      .website("betty.com")
      .build();
    Mockito.when(this.userRepository.findByUsername("John")).thenReturn(userEntity);

    // Test
    UserEntity result = this.userService.getUserByUsername("John");
    MatcherAssert.assertThat(result.getName(), is("Betty")); // import static org.hamcrest.Matchers.*;
    MatcherAssert.assertThat(result.getWebsite(), is("betty.com"));
  }
}
