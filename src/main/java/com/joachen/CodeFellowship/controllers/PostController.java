package com.joachen.CodeFellowship.controllers;

import com.joachen.CodeFellowship.models.ApplicationUser;
import com.joachen.CodeFellowship.models.ApplicationUserRepository;
import com.joachen.CodeFellowship.models.Post;
import com.joachen.CodeFellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.awt.print.Printable;
import java.security.Principal;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;

    @GetMapping("/post/makepost")
    public String getMakeAPost(Model m, Principal p) {
        m.addAttribute("user", p);
        return "post";
    }

    @PostMapping("/post/makepost")
    public RedirectView createPost(String body, Principal p) {
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(p.getName());
        Post post = new Post(body, loggedInUser);
        postRepository.save(post);
        return new RedirectView("/users/" + loggedInUser.getId());
    }
}
