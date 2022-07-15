package com.sloopdoge.blog.controllers;

import com.sloopdoge.blog.models.Items;
import com.sloopdoge.blog.repo.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddProductsController {

    @Autowired
    private ItemsRepository itemsRepository;

    /* Controller for Page to add item in database*/
    @GetMapping("/products/add")
    public String item(@RequestParam(name = "num", required = false) Integer num,
                       @RequestParam(name = "price", required = false) Double price,
                       @RequestParam(name = "name", required = false) String name, Model model) {
        Items item = new Items(num, price, name);
//        item.setNum(num);
//        item.setPrice(price);
//        item.setName(name);
        itemsRepository.save(item);
        return "item_add";
    }
}
