package com.macpietr.barbershop.barbershop.repository;

import com.macpietr.barbershop.barbershop.model.Barber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends CrudRepository<Barber, Long> {
}
