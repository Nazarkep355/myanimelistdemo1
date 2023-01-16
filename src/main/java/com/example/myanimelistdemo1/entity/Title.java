package com.example.myanimelistdemo1.entity;

import com.example.myanimelistdemo1.entity.enums.Genre;
import com.example.myanimelistdemo1.entity.enums.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name ="titles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

//@Document
public class Title {
    @Id
    private Long id;
    private String name;
    private String poster;
    private Type type;
    private Genre genre;
    private String studio;
    private int releaseYear;
    private String synopsis;
    private double rating;

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster='" + poster + '\'' +
                ", type=" + type +
                ", genre=" + genre +
                ", studio='" + studio + '\'' +
                ", releaseYear=" + releaseYear +
                ", synopsis='" + synopsis.substring(0,10) + '\'' +
                ", rating=" + rating +
                '}';
    }
}
