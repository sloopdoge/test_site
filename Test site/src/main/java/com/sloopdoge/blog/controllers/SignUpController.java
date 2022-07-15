package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.Role;
import com.sloopdoge.blog.models.User;
import com.sloopdoge.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Set;

@Controller
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    /* Controller for Sign up PAGE*/
    @GetMapping("/sign_up")
    public String sign_up(@RequestParam(name = "username", required = false) String username,
                          @RequestParam(name = "email", required = false) String email,
                          @RequestParam(name = "password", required = false) String password,
                          User user, Model model) {
        model.addAttribute("title", "Sign up page");

        User userFromDb = userRepository.findUserByEmail(user.getEmail());

        if (userFromDb != null) {
            System.out.println("User exists!");
            return "redirect:/login";
        }

        User newUser = new User(username, email, password);
        newUser.setActive(true);
        newUser.setRoles(Collections.singleton(Role.USER));
        userRepository.save(newUser);

        return "sign_up";
    }

}
