package com.macpietr.barbershop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexContorller {

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
