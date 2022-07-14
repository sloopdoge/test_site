package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.Items;
import com.sloopdoge.blog.repo.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private ItemsRepository itemsRepository;

    /* Controller for HOME PAGE*/
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
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
    public String item(@RequestParam(name = "num", required = false) Integer num, @RequestParam(name = "price", required = false) Double price, @RequestParam(name = "name", required = false) String name, Model model) {
        Items item = new Items(num, price, name);
//        item.setNum(num);
//        item.setPrice(price);
//        item.setName(name);
        itemsRepository.save(item);
        return "item_add";
    }

//    @PostMapping("/products/add")
//    public @ResponseBody String item_add(@RequestParam int num, @RequestParam double price, @RequestParam String name, Model model) {
//        Items item = new Items();
//        item.setNum(num);
//        item.setPrice(price);
//        item.setName(name);
//        itemsRepository.save(item);
//        return "home";
//    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Items> getAllItems() {
        return itemsRepository.findAll();
    }
}