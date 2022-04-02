package com.example.demo5.reply;

import com.example.demo5.BaseTimeEntity;
import com.example.demo5.posts.Posts;
import com.example.demo5.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    @Column(nullable = false, length = 500, columnDefinition = "TEXT")
    private String content;
    private String boardId;
    @Builder
    public Reply(String content, String author, String boardId){
        this.content = content;
        this.author = author;
        this.boardId = boardId;
    }


    public void update(String content){
        this.content = content;
    }
}

