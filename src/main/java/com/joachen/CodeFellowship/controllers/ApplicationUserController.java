package com.joachen.CodeFellowship.controllers;

import com.joachen.CodeFellowship.models.ApplicationUser;
import com.joachen.CodeFellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password, String firstname, String lastname, String dateOfBirth, String bio) {
        ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstname, lastname, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/userProfile");
    }

    @GetMapping("/myprofile")
    public String getUserProfile(Principal p, Model m){
        ApplicationUser applicationUser = null;
        if(p != null){
            applicationUser = applicationUserRepository.findByUsername(p.getName());
        }
        m.addAttribute("viewedUser", applicationUser);
        m.addAttribute("user", p);
        return "userProfile";
    }

    @GetMapping("/users/{id}")
    public String getOneUser(@PathVariable long id, Principal p, Model m) {
        ApplicationUser u = applicationUserRepository.findById(id).get();
        m.addAttribute("viewedUser", u);
        m.addAttribute("user", p);
        return "userProfile";
    }

}