package com.example.myanimelistdemo1.entity;

import com.example.myanimelistdemo1.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Document
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    @ElementCollection
    private Map<Title,Double> ratingList;
    @ManyToMany
    private List<Title> watchList;



}
