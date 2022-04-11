package com.example.demo5.service;

import com.example.demo5.reply.Reply;
import com.example.demo5.reply.ReplyRepository;
import com.example.demo5.user.LocalUser;
import com.example.demo5.user.LocalUserRepository;
import com.example.demo5.user.User;
import com.example.demo5.user.UserRepository;
import com.example.demo5.web.dto.ReplyListResponseDto;
import com.example.demo5.web.dto.ReplySaveRequestDto;
import com.example.demo5.web.dto.ReplyUpdateRequestDto;
import com.example.demo5.web.dto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final LocalUserRepository localUserRepository;

    @Transactional
    public Long save(UserSignUpDto userSignUpDto){
        return localUserRepository.save(userSignUpDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id){
        LocalUser user = localUserRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        localUserRepository.delete(user);
    }
}
