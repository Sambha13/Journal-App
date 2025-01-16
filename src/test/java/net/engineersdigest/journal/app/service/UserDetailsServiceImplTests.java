package net.engineersdigest.journal.app.service;

import net.engineersdigest.journal.app.entity.User;
import net.engineersdigest.journal.app.repository.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


@SpringBootTest
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Disabled
    @Test
    void loadUserByUSerNameTests(){
        //when(userRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn((User.builder().username("ram").password("asdf").roles(String.valueOf(new ArrayList<>())).build());
       // when(userRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().username("ram").password("ertyu").build());
       UserDetails user= userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}
