package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import com.example.demo5.reply.Reply;
import lombok.Getter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ReplyListResponseDto {
    private Long id;
    private String boardId;
    private String content;
    private String author;
    @Temporal(value = TemporalType.DATE)
    private String modifiedDate;


    public ReplyListResponseDto(Reply entity){
        this.id = entity.getId();
        this.content = entity.getContent();
        this.boardId = entity.getBoardId();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd mm:hh"));
    }
}
