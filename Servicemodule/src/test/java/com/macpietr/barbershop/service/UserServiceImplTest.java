package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {com.macpietr.barbershop.TestConfigurationClass.class})
class UserServiceImplTest {

    private UserService userService;

    @Autowired
    public UserServiceImplTest(UserService userService) {
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