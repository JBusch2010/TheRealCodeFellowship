package com.joachen.CodeFellowship.controllers;

import com.joachen.CodeFellowship.models.ApplicationUser;
import com.joachen.CodeFellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String getRoot(Principal p, Model m) {
        ApplicationUser applicationUser;
        if(p != null){
            applicationUser = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("viewedUser", applicationUser);
            m.addAttribute("user", p);
            return "userProfile";
        }
        return "root";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "registration";
    }

    @GetMapping("/login")
    public String getLoginPage () {
        return "/login";
    }
}
