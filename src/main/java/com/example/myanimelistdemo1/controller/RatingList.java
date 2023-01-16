package com.example.myanimelistdemo1.controller;

import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.entity.enums.Genre;
import com.example.myanimelistdemo1.service.FindTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rating")
@CrossOrigin(origins = "http://localhost:4200")
public class RatingList {
    @Autowired
    private FindTitleService findTitleService;

    @GetMapping
    public Page<Title> ratingList(Optional<Genre> genre, Pageable pageable) {
        Page page = findTitleService.findRating(genre, pageable);
        System.out.println(page.getContent());
        return page;
    }
}
