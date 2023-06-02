package com.example.minidoorayproject;

import com.example.minidoorayproject.entity.User;
import com.example.minidoorayproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MiniDoorayUserRepositoryTests {

  @Autowired
  private UserRepository userRepository;

  @Test
  void saveUserTest() {
    User user = new User();
    user.setUserId(200);
    user.setId("Abigail");
    user.setEmail("Abi@nhn.com");
    user.setPassword("pass200");
    userRepository.saveAndFlush(user);
  }

  @Test
  void getUserTest() {
    User user = userRepository.getUserByIdIs("Abigail");
    assertThat(user.getUserId()).isEqualTo(200);
  }
}
