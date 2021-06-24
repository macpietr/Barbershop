package com.macpietr.barbershop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@MappedSuperclass
@Getter @Setter @ToString @EqualsAndHashCode
public abstract class Person extends BaseEntity{

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private boolean confirmed;
    private int wrongLoginCount;
}
