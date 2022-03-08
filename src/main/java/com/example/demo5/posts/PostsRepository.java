package com.example.demo5.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p WHERE p.boardnumber='1' ORDER by p.id DESC")
    List<Posts> findAllDesc();
    @Query("SELECT p FROM Posts p WHERE p.boardnumber='2' ORDER by p.id DESC")
    List<Posts> findAllDesc2();
}
