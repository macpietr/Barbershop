package datamodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarberTest {

    @Test
    void testLombok(){
        Barber barber = new Barber();
        barber.setFirstname("mack");
        assertEquals("mack",barber.getFirstname());
    }
}