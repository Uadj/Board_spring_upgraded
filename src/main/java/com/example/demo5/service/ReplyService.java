package com.example.demo5.service;

import com.example.demo5.posts.Posts;
import com.example.demo5.posts.PostsRepository;
import com.example.demo5.reply.Reply;
import com.example.demo5.reply.ReplyRepository;
import com.example.demo5.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    @Transactional
    public Long save(ReplySaveRequestDto requestDto){
        return replyRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ReplyUpdateRequestDto requestDto){
        Reply reply = replyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id="+id));
        reply.update(requestDto.getContent());
        return id;
    }
    @Transactional
    public void delete(Long id){
        Reply reply = replyRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        replyRepository.delete(reply);
    }

    @Transactional(readOnly = true)
    public List<ReplyListResponseDto> findAllDesc(Long BoardId){
        return replyRepository.findAll(BoardId).stream()
                .map(ReplyListResponseDto::new)
                .collect(Collectors.toList());
    }

}
