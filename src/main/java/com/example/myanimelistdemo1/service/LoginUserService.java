package com.example.myanimelistdemo1.service;

import com.example.myanimelistdemo1.entity.User;
import com.example.myanimelistdemo1.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserService {

    @Autowired
    private UserDAO userDAO;
    public User loginUser(String email, String password){
        Optional<User> userOptional = userDAO.findByEmail(email);
        if(userOptional.isEmpty()){
            return new User();
        }
        if(!userOptional.get().getPassword().equals(password)){
            return new User();
        }
        return userOptional.get();
    }
}
