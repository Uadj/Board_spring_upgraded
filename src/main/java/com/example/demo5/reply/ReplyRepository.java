package com.example.demo5.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query(value="select r from Reply r where r.boardId like " +
            "%:boardId% order by r.id desc")
    List<Reply> findAll(@Param("boardId") String boardId);
}
