package com.macpietr.barbershop.barbershop.repository;

import com.macpietr.barbershop.barbershop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
