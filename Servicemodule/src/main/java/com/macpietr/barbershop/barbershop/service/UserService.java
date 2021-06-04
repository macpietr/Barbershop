package com.macpietr.barbershop.barbershop.service;

import com.macpietr.barbershop.barbershop.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findUserById(Long id);
    List<User> findAllUsers();
    void saveUser(User user);
}
