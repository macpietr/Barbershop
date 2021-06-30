package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.Reservation;
import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private ReservationRepository reservationRepository;


    @Override
    public Reservation findReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> findReservationsByUser(User user) {
        return reservationRepository.findAllByUser(user);
    }
}
