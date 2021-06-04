package com.macpietr.barbershop.barbershop.service;

import com.macpietr.barbershop.barbershop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration
@SpringBootTest
class UserServiceImplTest {

    private UserServiceImpl userService;

    public UserServiceImplTest(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Test
    void checkUserServiceImpl(){
        User user = new User();
        user.setFirstname("mack");
        user.setLastname("Mackowski");
        userService.saveUser(user);
        User user1 = userService.findUserById(1L);
        assertEquals(user,user1);
    }

}