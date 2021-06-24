package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    User findUserByEmail(String email);
    User findUserByConfirmationUrl(String confirmationUrl);
    List<User> findAllUsers();
    void saveUser(User user);
    void saveAllUsers(List<User> users);
}
