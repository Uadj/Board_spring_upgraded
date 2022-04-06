package com.example.demo5.web.dto;

import com.example.demo5.reply.Reply;
import com.example.demo5.service.ReplyService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String boardnumber;
    @Builder
    public PostsUpdateRequestDto(String title, String content, String boardnumber){
        this.title = title;
        this.content = content;
        this.boardnumber = boardnumber;
    }

}
