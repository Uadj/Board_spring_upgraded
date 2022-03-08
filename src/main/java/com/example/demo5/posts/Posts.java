package com.example.demo5.posts;

import com.example.demo5.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500, nullable = false)

    @NotBlank(message = "제목은 반드시 입력해야합니다.")
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;
    private String boardnumber;
    @Builder
    public Posts(String title, String content, String author, String boardnumber){
        this.title = title;
        this.content = content;
        this.author = author;
        this.boardnumber = boardnumber;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
