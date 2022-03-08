package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import com.example.demo5.reply.Reply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyListResponseDto {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;
    private String BoardId;

    public ReplyListResponseDto(Reply entity){
        this.id = entity.getId();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.BoardId = entity.getBoardId();
    }
}
