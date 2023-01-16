package com.example.myanimelistdemo1.dto;

import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.entity.User;
import com.example.myanimelistdemo1.entity.enums.Role;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private List<Title> watchList;
    public static UserDTO getDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(),
                user.getRole(),user.getWatchList());
    }
}
