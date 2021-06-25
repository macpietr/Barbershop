package com.macpietr.barbershop;

import com.macpietr.barbershop.model.Barber;
import com.macpietr.barbershop.model.Person;
import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.service.BarberService;
import com.macpietr.barbershop.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private UserService userService;
    private BarberService barberService;
    private PasswordEncoder passwordEncoder;

    public DataLoader(UserService userService, BarberService barberService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.barberService = barberService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        User user = new User();
        user.setEmail("mack@mack.pl");
        user.setFirstname("mack");
        user.setLastname("mackowski");
        user.setPassword(passwordEncoder.encode("mack"));
        user.setRole("ROLE_USER");
        user.setConfirmed(true);

        User user1 = new User();
        user1.setEmail("zuz@zuz.pl");
        user1.setFirstname("zuz");
        user1.setLastname("kochany");
        user1.setPassword(passwordEncoder.encode("zuz"));
        user1.setRole("ROLE_USER");
        user1.setConfirmed(true);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);

        Barber barber = new Barber();
        barber.setEmail("admin@admin.pl");
        barber.setFirstname("admin");
        barber.setPassword(passwordEncoder.encode("admin"));
        barber.setRole("ROLE_ADMIN");
        barber.setConfirmed(true);

        userService.saveAllUsers(userList);
        barberService.saveBarber(barber);

        User user2 = userService.findUserById(1L);
        System.out.println(user2.toString());
        List<User> users = userService.findAllUsers();
        users.forEach(System.out::println);

        System.out.println("#####################");

        Barber barber1 = barberService.findBarberById(1L);
        System.out.println(barber1.getLastname());
        List<Barber> barbers = barberService.findAllBarbers();
        barbers.forEach(System.out::println);

    }
}
