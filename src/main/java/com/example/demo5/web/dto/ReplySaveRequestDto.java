package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import com.example.demo5.reply.Reply;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplySaveRequestDto {
    private Long id;
    private String content;
    private String author;

    @Builder
    public ReplySaveRequestDto(Long id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }
    public Reply toEntity(){
        return Reply.builder()
                .content(content)
                .author(author)
                .build();
    }
}
