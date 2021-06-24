package com.macpietr.barbershop.controller;

import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.service.BarberService;
import com.macpietr.barbershop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class SignUpController {

    private UserService userService;
    private BarberService barberService;

    @GetMapping("/signup")
    public String goToSignUpPage(Model model){
        model.addAttribute("newUser",new User());
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user){
        if(userService.findUserByEmail(user.getEmail())==null
                && barberService.findBarberByEmail(user.getEmail())==null){
            user.setRole("ROLE_USER");
            userService.saveUser(user);
            return "redirect:/login";
        }else {
            return "redirect:/signup?error";
        }
    }
}
