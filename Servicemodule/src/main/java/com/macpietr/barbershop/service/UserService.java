package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);
    User findUserByEmail(String email);
    User findUserByFirstname(String firstname);
    List<User> findAllUsers();
    void saveUser(User user);
}
