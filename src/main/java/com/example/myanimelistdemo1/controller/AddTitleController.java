package com.example.myanimelistdemo1.controller;

import com.example.myanimelistdemo1.dto.TitleDTO;
import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.service.AddTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddTitleController {
    @Autowired
    private AddTitleService addTitleService;

    @GetMapping
    public Title addTitle(TitleDTO dto) {
        return addTitleService.save(dto);
    }
}
