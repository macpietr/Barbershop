package com.macpietr.barbershop.repository;

import com.macpietr.barbershop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByFirstname(String firstname);
}
