package com.example.myanimelistdemo1.controller;

import com.example.myanimelistdemo1.dto.LoginUserDTO;
import com.example.myanimelistdemo1.dto.UserDTO;
import com.example.myanimelistdemo1.entity.User;
import com.example.myanimelistdemo1.service.LoginUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class LoginUserController {
    @Autowired
    private LoginUserService loginService;

    @PostMapping()
    public UserDTO loginUser(@RequestBody LoginUserDTO user) {
        return UserDTO.getDTO(loginService.loginUser(user.getEmail(), user.getPassword()));
    }
}
