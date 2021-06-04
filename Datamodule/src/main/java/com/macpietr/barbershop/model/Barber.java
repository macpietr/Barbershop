package com.macpietr.barbershop.barbershop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter @Setter
public class Barber extends Person{

    @OneToMany(mappedBy = "barber")
    Set<Reservation> reservations;
}
