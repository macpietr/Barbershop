package com.macpietr.barbershop.security;

import com.macpietr.barbershop.model.Person;
import com.macpietr.barbershop.model.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String email;
    private String password;
    private String role;
    private boolean confirmed;

    public UserDetailsImpl(Person person) {
        this.email = person.getEmail();
        this.password = person.getPassword();
        this.role = person.getRole();
        this.confirmed = person.isConfirmed();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return confirmed;
    }
}
