package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.Items;
import com.sloopdoge.blog.repo.ItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<Items> getAllItems() {
//        return itemsRepository.findAll();
//    }
}