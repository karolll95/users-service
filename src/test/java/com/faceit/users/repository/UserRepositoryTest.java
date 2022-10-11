package com.faceit.users.repository;

import com.faceit.users.TestContainerTests;
import com.faceit.users.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryTest extends TestContainerTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void canPersistNewUser() {
        //given
        var user = User.builder()
                .firstName("Some new user")
                .build();

        //when
        userRepository.save(user);

        //then
        assertTrue(userRepository.findById(user.getId()).isPresent());
    }
}