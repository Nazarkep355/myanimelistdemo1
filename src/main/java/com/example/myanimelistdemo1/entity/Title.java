package com.example.myanimelistdemo1.entity;

import com.example.myanimelistdemo1.entity.enums.Genre;
import com.example.myanimelistdemo1.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Title {
    @Id
    private Long id;
    private String name;
    private Type type;
    private Genre genre;
    private String studio;
    private int releaseYear;
    private String synopsis;
    private double rating;
}
