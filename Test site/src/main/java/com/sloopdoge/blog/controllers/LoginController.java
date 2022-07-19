package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.MyUser;
import com.sloopdoge.blog.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    /* Controller for Login PAGE*/
    @GetMapping("/login")
    public String login(Model model) {
//        Iterable<MyUser> user = userRepository.findAll();
//        System.out.println((UserDetails)authentication.getPrincipal());
        model.addAttribute("title", "Login page");

        return "login";
    }

}
