package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);
    List<User> findAllUsers();
    void saveUser(User user);
}
