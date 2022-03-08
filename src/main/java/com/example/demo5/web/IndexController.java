package com.example.demo5.web;

import com.example.demo5.config.auth.LoginUser;
import com.example.demo5.config.auth.dto.SessionUser;
import com.example.demo5.service.PostsService;
import com.example.demo5.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
    @GetMapping("/board2")
    public String b2(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc2());
        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "board2";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
