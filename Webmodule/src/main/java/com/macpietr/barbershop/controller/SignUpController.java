package com.macpietr.barbershop.controller;

import com.macpietr.barbershop.MailService;
import com.macpietr.barbershop.UrlGenerator;
import com.macpietr.barbershop.model.User;
import com.macpietr.barbershop.service.BarberService;
import com.macpietr.barbershop.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;

@Controller
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class SignUpController {

    private UserService userService;
    private BarberService barberService;
    private MailService mailService;

    @Value("${confirmation.email.subject}")
    private String emailSubject;
    @Value("${confirmation.email.url}")
    private String confirmationUrl;

    public SignUpController(UserService userService, BarberService barberService, MailService mailService) {
        this.userService = userService;
        this.barberService = barberService;
        this.mailService = mailService;
    }

    @GetMapping("/signup")
    public String goToSignUpPage(Model model) {
        model.addAttribute("newUser", new User());
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user) throws MessagingException {
        if (userExitsInDb(user)) {
            return "redirect:/signup?error";
        } else {
            setUserDetails(user);
            userService.saveUser(user);
            sendConfirmationEmail(user);
            return "redirect:/confirmation";
        }
    }

    @GetMapping("/confirmation")
    public String goToConfirmationPage() {
        return "confirmation";
    }

    private boolean userExitsInDb(User user) {
        if (userService.findUserByEmail(user.getEmail()) == null
                && barberService.findBarberByEmail(user.getEmail()) == null) {
            return false;
        } else {
            return true;
        }
    }

    private void setUserDetails(User user) {
        user.setRole("ROLE_USER");
        user.setConfirmationUrl(UrlGenerator.generate());
        user.setConfirmed(false);
    }

    private void sendConfirmationEmail(User user) {
        try {
            mailService.sendEmail(user.getEmail(), emailSubject, confirmationUrl + user.getConfirmationUrl());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}