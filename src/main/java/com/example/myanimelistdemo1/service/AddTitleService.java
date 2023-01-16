package com.example.myanimelistdemo1.service;

import com.example.myanimelistdemo1.dto.TitleDTO;
import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.repos.TitleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddTitleService {
    @Autowired
    private TitleDAO titleDAO;
    public Title save(TitleDTO dto){
        Title title = new Title();
        title.setId(titleDAO.count()+1);
        title.setName(dto.getName());
        title.setGenre(dto.getGenre());
        title.setStudio(dto.getStudio());
        title.setRating(dto.getRating());
        title.setSynopsis(dto.getSynopsis());
        title.setType(dto.getType());
        title.setReleaseYear(dto.getReleaseYear());
        return titleDAO.save(title);
    }
}
