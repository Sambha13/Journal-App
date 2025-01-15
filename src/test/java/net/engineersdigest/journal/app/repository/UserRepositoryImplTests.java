package net.engineersdigest.journal.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTests {
    private UserRepositoryImpl userRepository;
    @Test
    public void testSaveNewUser(){
        userRepository.getUsersForSA();


    }
}
