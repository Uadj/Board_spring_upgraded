package com.example.demo5.service;

import com.example.demo5.posts.Posts;
import com.example.demo5.posts.PostsRepository;
import com.example.demo5.web.dto.PostsListResponseDto;
import com.example.demo5.web.dto.PostsResponseDto;
import com.example.demo5.web.dto.PostsSaveRequestDto;
import com.example.demo5.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent(), requestDto.getBoardnumber());
        return id;
    }
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(posts);
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc2(){
        return postsRepository.findAllDesc2().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findByKeyword1(String keyword){
        return postsRepository.findByKeyword1(keyword).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findByKeyword2(String keyword){
        return postsRepository.findByKeyword2(keyword).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
