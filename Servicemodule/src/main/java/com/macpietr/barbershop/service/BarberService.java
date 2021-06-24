package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.Barber;

import java.util.List;

public interface BarberService {
    Barber findBarberById(Long id);
    Barber findBarberByEmail(String email);
    List<Barber> findAllBarbers();
    void saveBarber(Barber barber);
}
