package com.macpietr.barbershop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarberTest {

    @Test
    void checkLombok(){
        Barber barber = new Barber();
        barber.setFirstname("Jack");
        assertEquals("Jack",barber.getFirstname());
    }
}