package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import com.example.demo5.reply.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReplySaveRequestDto {
    private String content;
    private String boardId;
    private String author;

    @Builder
    public ReplySaveRequestDto(String content, String boardId, String author){
        this.content = content;
        this.boardId = boardId;
        this.author = author;
    }
    public Reply toEntity(){
        return Reply.builder()
                .content(content)
                .boardId(boardId)
                .author(author)
                .build();
    }
}
