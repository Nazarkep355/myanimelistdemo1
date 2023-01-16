package com.example.myanimelistdemo1.service;

import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.entity.enums.Genre;
import com.example.myanimelistdemo1.repos.TitleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindTitleService {
    @Autowired
    private TitleDAO titleDAO;

    public Page<Title> findRating(Optional<Genre> genreOptional, Pageable pageable) {
        if (genreOptional.isEmpty()) {
            Sort.Order order =new Sort.Order(Sort.Direction.DESC,"rating");
            pageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),
                    Sort.by(order));
            return titleDAO.findAll(pageable);
        } else {
            return titleDAO.findAllByGenreOrderByRatingDesc(genreOptional.get(),pageable);
        }
    }

    public Page<Title> findTitleByName(String name,Pageable pageable){
        Optional<Title> title = titleDAO.findTitleByName(name);
        if(title.isPresent()){
            return new PageImpl<Title>(List.of(title.get()));
        }
        else
            return titleDAO.findTitlesByNameContainingIgnoreCase(name,pageable);
    }

}
