package com.macpietr.barbershop.repository;

import com.macpietr.barbershop.model.Barber;
import com.macpietr.barbershop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends CrudRepository<Barber, Long> {
    Barber findByEmail(String email);
}
