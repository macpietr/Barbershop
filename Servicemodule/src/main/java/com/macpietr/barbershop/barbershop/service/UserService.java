package com.macpietr.barbershop.barbershop.service;

import com.macpietr.barbershop.barbershop.model.User;

public interface UserService {

    User findUserById(Long id);
    void saveUser(User user);
}
