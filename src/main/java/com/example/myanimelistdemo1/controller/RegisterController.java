package com.example.myanimelistdemo1.controller;

import com.example.myanimelistdemo1.entity.User;
import com.example.myanimelistdemo1.service.RegisterUserService;
import com.example.myanimelistdemo1.service.ReviewTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterUserService registerService;
    @Autowired
    private ReviewTitleService reviewService;

    @PostMapping
    public User registerUser(User user) {
        return registerService.registerUser(user.getEmail(), user.getPassword(), user.getName());
    }
    @GetMapping
    public void reviewNow(double rating,Long user,Long title){
        reviewService.mockReview(rating,user,title);
    }
}
