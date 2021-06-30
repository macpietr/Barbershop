package com.macpietr.barbershop.controller;

import com.macpietr.barbershop.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ReservationController {

    private ReservationService reservationService;

    @GetMapping({"/reservation","/reservation.html"})
    public String reservationPage(){
        return "reservation";
    }
}
