package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    /* Controller for Login PAGE*/
    @GetMapping("/login")
    public String login(User user, Model model) {
        model.addAttribute("title", "Login page");


        return "login";
    }

}
