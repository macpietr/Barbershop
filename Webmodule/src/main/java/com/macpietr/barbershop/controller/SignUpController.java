package com.macpietr.barbershop.controller;

import com.macpietr.barbershop.MailService;
import com.macpietr.barbershop.UrlGenerator;
import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.service.BarberService;
import com.macpietr.barbershop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;

@Controller
@AllArgsConstructor
public class SignUpController {

    private UserService userService;
    private BarberService barberService;
    private MailService mailService;

    @GetMapping("/signup")
    public String goToSignUpPage(Model model){
        model.addAttribute("newUser",new User());
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user) throws MessagingException {
        if(userService.findUserByEmail(user.getEmail())==null
                && barberService.findBarberByEmail(user.getEmail())==null){
            user.setRole("ROLE_USER");
            user.setConfirmationUrl(UrlGenerator.generate());
            user.setConfirmed(false);
            userService.saveUser(user);
            //todo: remove it later
            System.out.println("#############");
            System.out.println("localhost:8080/confirmEmail?confirmationUrl="+user.getConfirmationUrl());
            System.out.println("#############");
            //todo: test if receiver exists
            mailService.sendEmail(user.getEmail(),"Confirm your account","localhost:8080/confirmEmail?confirmationUrl="+user.getConfirmationUrl());
            return "redirect:/confirmation";
        }else {
            return "redirect:/signup?error";
        }
    }

    @GetMapping("/confirmation")
    public String goToConfirmationPage(){
        return "confirmation";
    }
}
