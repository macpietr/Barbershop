package com.macpietr.barbershop.repository;

import com.macpietr.barbershop.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Long, Reservation> {
}
