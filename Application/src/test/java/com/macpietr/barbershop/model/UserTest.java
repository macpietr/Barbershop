package com.macpietr.barbershop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testLombok(){
        User user = new User();
        user.setFirstname("MACK");
        assertEquals("MACK",user.getFirstname());
    }

}