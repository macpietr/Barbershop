package com.macpietr.barbershop.controller;

import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("users", userService.findAllUsers());
        return "user";
    }

    @GetMapping("/adduser")
    public String addUser(Model model){
        model.addAttribute("newUser", new User());
        return "adduser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/adduser";
    }

    @GetMapping({"/login.html","login"})
    public String login(){ return "login";}
}