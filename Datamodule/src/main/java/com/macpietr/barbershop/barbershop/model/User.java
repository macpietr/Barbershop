package com.macpietr.barbershop.barbershop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter @EqualsAndHashCode
public class User extends Person{

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;
}
