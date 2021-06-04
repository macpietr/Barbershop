package com.macpietr.barbershop.barbershop.repository;

import com.macpietr.barbershop.barbershop.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
