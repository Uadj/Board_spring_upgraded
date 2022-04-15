package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String boardnumber;
    private Integer views;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author, String boardnumber, Integer views){
        this.title = title;
        this.content = content;
        this.author = author;
        this.boardnumber = boardnumber;
        this.views = 0;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .boardnumber(boardnumber)
                .build();
    }
}
