package com.macpietr.barbershop.controller;

import com.macpietr.barbershop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class IndexContorller {

    UserService userService;

    @GetMapping({"","/","/index","/index.html"})
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("user", userService.findUserById(1L));
        return "user";
    }

    @GetMapping({"/login.html","login"})
    public String login(){ return "login";}
}