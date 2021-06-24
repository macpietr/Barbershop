package com.macpietr.barbershop.security;

import com.macpietr.barbershop.service.BarberService;
import com.macpietr.barbershop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    private BarberService barberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userService.findUserByEmail(username)==null){
            return new UserDetailsImpl(barberService.findBarberByEmail(username));
        }else {
            return new UserDetailsImpl(userService.findUserByEmail(username));
        }
    }
}
