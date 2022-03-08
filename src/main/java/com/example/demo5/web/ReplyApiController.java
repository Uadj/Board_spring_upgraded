package com.example.demo5.web;

import com.example.demo5.service.PostsService;
import com.example.demo5.service.ReplyService;
import com.example.demo5.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {
    private final ReplyService replyService;

    @PostMapping("/api/v1/reply")
    public Long save(@RequestBody ReplySaveRequestDto requestDto){
        return replyService.save(requestDto);
    }

    @PutMapping("/api/v1/reply/{id}")
    public Long update(@PathVariable Long id, @RequestBody ReplyUpdateRequestDto requestDto) {
        return replyService.update(id, requestDto);
    }
    @DeleteMapping("/api/v1/reply/{id}")
    public Long delete(@PathVariable Long id){
        replyService.delete(id);
        return id;
    }
}
