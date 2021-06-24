package com.macpietr.barbershop.controller;

import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ConfirmationController {

    private UserService userService;

    @GetMapping("/confirmEmail")
    public String confirmEmail(@RequestParam String confirmationUrl) {
        User user = userService.findUserByConfirmationUrl(confirmationUrl);
        if (user != null && !user.isConfirmed()) {
            user.setConfirmed(true);
            userService.saveUser(user);
            return "redirect:/thanks";
        }else {
            return "redirect:/comeon";
        }
    }

    @GetMapping("/thanks")
    public String goToThanksPage(){
        return "thanks";
    }

    @GetMapping("/comeon")
    public String goToComeonPage(){
        return "comeon";
    }
}