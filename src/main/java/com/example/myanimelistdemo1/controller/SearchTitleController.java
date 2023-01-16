package com.example.myanimelistdemo1.controller;

import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.service.FindTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SearchTitleController {

    @Autowired
    private FindTitleService findTitleService;


    @GetMapping("/title")
    public Page<Title> findTitle(Pageable pageable, Optional<String> name,
                                 Optional<String> synopsis, Optional<String> studio,
                                 Optional<Integer> year) {
        System.out.println("/title");
        Page page=null;
        if (name.isPresent() && !name.get().isBlank()) {
            page= findTitleService.findTitleByName(name.get(), pageable);
            System.out.println(page);
            return page;
        }
        if (synopsis.isPresent() && !synopsis.get().isBlank()) {
            return null;
        }
        else
            throw new UnsupportedOperationException();
    }
}
