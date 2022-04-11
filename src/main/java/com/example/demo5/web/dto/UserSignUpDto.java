package com.example.demo5.web.dto;

import com.example.demo5.reply.Reply;
import com.example.demo5.user.LocalUser;
import com.example.demo5.user.User;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class UserSignUpDto {
    private Long id;
    private Long password;
    private String name;
    private String email;

    public LocalUser toEntity(){
        return LocalUser.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
