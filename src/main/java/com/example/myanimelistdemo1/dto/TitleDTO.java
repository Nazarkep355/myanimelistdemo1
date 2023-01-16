package com.example.myanimelistdemo1.dto;

import com.example.myanimelistdemo1.entity.enums.Genre;
import com.example.myanimelistdemo1.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TitleDTO {
    private String name;
    private String poster;
    private Type type;
    private Genre genre;
    private String studio;
    private int releaseYear;
    private String synopsis;
    private double rating;
}
