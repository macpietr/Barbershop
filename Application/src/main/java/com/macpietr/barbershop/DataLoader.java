package com.macpietr.barbershop;

import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstname("mack");
        user.setLastname("mackowski");

        userService.saveUser(user);
        User user1 = userService.findUserById(1L);
        System.out.println(user1.getLastname());
        List<User> users = userService.findAllUsers();
        users.forEach(System.out::println);

    }
}