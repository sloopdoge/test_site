package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.Items;
import com.sloopdoge.blog.repo.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private ItemsRepository itemsRepository;

    /* Controller for HOME PAGE*/
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }

    /* Controller for Dashboard PAGE*/
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("title", "Dashboard");
        return "dashboard";
    }

    /* Controller for Products PAGE*/
    @GetMapping("/products")
    public String products(Model model) {
        Iterable<Items> items = itemsRepository.findAll();
        model.addAttribute("items", items);
        return "products";
    }

    /* Controller for About PAGE*/
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About us");
        return "about";
    }

    /* Controller for Login PAGE*/
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login page");
        return "login";
    }

    /* Controller for Sign up PAGE*/
    @GetMapping("/sign_up")
    public String sign_up(Model model) {
        model.addAttribute("title", "Sign up page");
        return "sign_up";
    }

    /* Controller for Page to add item in database*/
    @GetMapping("/products/add")
    public String item(Model model) {
        return "item_add";
    }

    @PostMapping("/products/add")
    public String item_add(@RequestParam int num, @RequestParam double price, @RequestParam String name, Model model) {
        Items item = new Items(num, price, name);
        itemsRepository.save(item);
        return "refresh";
    }
}