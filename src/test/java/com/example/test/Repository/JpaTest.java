package com.example.test.Repository;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JpaTest {

    //@Autowired
    //private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("/jpa test")
    @Test
    void user_insert_test() throws Exception {
        //given
        String testName = "testusertest";
        String testPassword = "test1234test";

        final User user = User.builder()
                .username(testName)
                .password(testPassword)
                .build();

        //when
        final User testUser = userRepository.save(user);

        //then
        assertEquals(testName, testUser.getUsername());
    }
}