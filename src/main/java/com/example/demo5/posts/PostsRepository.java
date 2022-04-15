package com.example.demo5.posts;

import com.example.demo5.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p WHERE p.boardnumber='1' ORDER by p.id DESC")
    List<Posts> findAllDesc();
    @Query("SELECT p FROM Posts p WHERE p.boardnumber='2' ORDER by p.id DESC")
    List<Posts> findAllDesc2();
    @Query("SELECT p FROM Posts p WHERE p.boardnumber='1' and p.title like %:keyword% ORDER by p.id DESC")
    List<Posts> findByKeyword1(@Param("keyword") String keyword);
    @Query("SELECT p FROM Posts p WHERE p.boardnumber='2' and p.title like %:keyword% ORDER by p.id DESC")
    List<Posts> findByKeyword2(@Param("keyword") String keyword);

    @Transactional
    @Modifying
    @Query("update Posts p set p.views = p.views + 1 where p.id = :id")
    void updateViews(@Param("id") Long id);
}
