package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.MyUser;
import com.sloopdoge.blog.models.Role;
import com.sloopdoge.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    /* Controller for Sign up PAGE*/
    @GetMapping("/sign_up")
    public String sign_up(Model model) {
        model.addAttribute("title", "Sign up page");
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String addUser(MyUser myUser,
                          @RequestParam(name = "username") String username,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "password") String password) {
        MyUser myUserFromDb = userRepository.findUserByEmail(myUser.getEmail());

        if (myUserFromDb != null) {
            System.out.println("_ERROR_: " + "User exists!");
            return "sign_up";
        }

        MyUser newMyUser = new MyUser(username, email, password);
        newMyUser.setActive(true);
        newMyUser.setRole(Collections.singleton(Role.USER));
        userRepository.save(newMyUser);

        return "redirect:/login";
    }
}
