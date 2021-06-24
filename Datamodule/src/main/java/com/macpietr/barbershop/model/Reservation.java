package com.macpietr.barbershop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter @Setter
public class Reservation extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    private Date term;
    private Timestamp startDate;
    private Timestamp endDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Barber barber;
}
