package com.macpietr.barbershop.barbershop.service;

import com.macpietr.barbershop.barbershop.model.User;
import com.macpietr.barbershop.barbershop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
