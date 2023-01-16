package com.example.myanimelistdemo1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginUserDTO {
    private String email;
    private String password;
}
