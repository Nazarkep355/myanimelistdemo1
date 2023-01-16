package com.example.myanimelistdemo1.service;

import com.example.myanimelistdemo1.entity.User;
import com.example.myanimelistdemo1.entity.enums.Role;
import com.example.myanimelistdemo1.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class RegisterUserService {
    @Autowired
    private UserDAO userDAO;

    public User registerUser(String email, String password, String name) {
        if (userDAO.findByEmail(email).isPresent() || userDAO.findByName(name).isPresent()) {
            throw new IllegalArgumentException("exists");
        }
        User newUser = createUser(email, password, name);
        newUser.setId(userDAO.count() + 1);
        return userDAO.save(newUser);
    }

    private User createUser(String email, String password, String name) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setRatingList(new HashMap<>());
        user.setRole(Role.USER);
        user.setWatchList(new ArrayList<>());
        return user;
    }
}
