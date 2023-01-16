package com.example.myanimelistdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImageController {
    @GetMapping("/image/{name}")
    public String image(@PathVariable("name")String name, Model model){
        model.addAttribute("image",name);
        return "image_page.html";
    }
}
