package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.Reservation;
import com.macpietr.barbershop.model.User;

import java.util.List;

public interface ReservationService {
    Reservation findReservationById(Long id);
    List<Reservation> findReservationsByUser(User user);
}
