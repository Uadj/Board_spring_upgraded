package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String boardnumber;
    private Integer views;
    private String modifiedDate;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.boardnumber = entity.getBoardnumber();
        this.views = entity.getViews();
        this.modifiedDate = entity.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd mm:hh"));
    }
}
