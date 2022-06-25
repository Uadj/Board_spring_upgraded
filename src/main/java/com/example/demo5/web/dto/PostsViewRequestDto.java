package com.example.demo5.web.dto;

import com.example.demo5.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@NoArgsConstructor
public class PostsViewRequestDto {
        private String title;
        private String content;
        private String author;
        private String boardnumber;
        private String modifiedDate;
        @Builder
        public PostsViewRequestDto(Posts entity){
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.content = entity.getContent();
            this.modifiedDate = entity.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd mm:hh"));
            this.boardnumber = entity.getBoardnumber();
        }
}
