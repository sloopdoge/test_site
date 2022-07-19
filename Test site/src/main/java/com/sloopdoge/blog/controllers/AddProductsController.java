package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.Items;
import com.sloopdoge.blog.repo.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddProductsController {

    @Autowired
    private ItemsRepository itemsRepository;

    /* Controller for Page to add item in database*/
    @GetMapping("/products/add")
    public String item(Model model) {
        return "item_add";
    }

    @PostMapping("/products/add")
    public String itemAdd(@RequestParam(name = "num") Integer num,
                       @RequestParam(name = "price") Double price,
                       @RequestParam(name = "name") String name, Model model) {
        Items item = new Items(num, price, name);
//        item.setNum(num);
//        item.setPrice(price);
//        item.setName(name);
        itemsRepository.save(item);
        return "item_add";
    }
}
