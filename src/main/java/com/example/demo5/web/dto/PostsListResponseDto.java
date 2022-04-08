package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String modifiedDate;
    private String boardnumber;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.boardnumber = entity.getBoardnumber();
    }
}
