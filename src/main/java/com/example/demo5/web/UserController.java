package com.example.demo5.web;

import com.example.demo5.service.ReplyService;
import com.example.demo5.service.UserService;
import com.example.demo5.web.dto.ReplySaveRequestDto;
import com.example.demo5.web.dto.ReplyUpdateRequestDto;
import com.example.demo5.web.dto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSignUpDto userSignUpDto){
        return userService.save(userSignUpDto);
    }

    @DeleteMapping("/api/v1/user/{id}")
    public Long delete(@PathVariable Long id){
        userService.delete(id);
        return id;
    }
}
