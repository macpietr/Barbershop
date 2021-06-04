package com.macpietr.barbershop.barbershop;

import com.macpietr.barbershop.barbershop.model.User;
import com.macpietr.barbershop.barbershop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    }
}
