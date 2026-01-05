package com.study.dtopractice.bbs.post.controller;

import com.study.dtopractice.bbs.post.dto.request.CreatePostRequest;
import com.study.dtopractice.bbs.post.dto.response.CreatePostResponse;
import com.study.dtopractice.bbs.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbs/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public CreatePostResponse createPost(@Valid @RequestBody CreatePostRequest req){
        return postService.createPost(req);
    }
}
