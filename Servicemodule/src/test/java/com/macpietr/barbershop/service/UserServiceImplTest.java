package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {com.macpietr.barbershop.TestConfigurationClass.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceImplTest {

    private UserService userService;
    private User user = new User();

    @Autowired
    public UserServiceImplTest(UserService userService) {
        this.userService = userService;
    }

    @BeforeAll
    void setUserData() {
        user.setFirstname("mack");
        user.setLastname("Mackowski");
        user.setEmail("mack@mack.pl");
        user.setPassword("mackpass");
        userService.saveUser(user);
    }

    @Test
    void testFindUserById() {
        User user1 = userService.findUserById(1L);
        assertEquals(user, user1);
    }

    @Test
    void testFindUserByEmail() {
        User user1 = userService.findUserByEmail("mack@mack.pl");
        assertEquals(user, user1);
    }

    @Test
    void testFindUserByFirstname(){
        User user1 = userService.findUserByFirstname("mack");
        assertEquals(user,user1);
    }

}