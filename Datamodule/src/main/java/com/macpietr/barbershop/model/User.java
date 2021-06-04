package com.macpietr.barbershop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
public class User extends Person{

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;
}
