package com.study.dtopractice.bbs.post.controller;

import com.study.dtopractice.bbs.post.domain.Post;
import com.study.dtopractice.bbs.post.dto.request.CreatePostRequest;
import com.study.dtopractice.bbs.post.dto.response.CreatePostResponse;
import com.study.dtopractice.bbs.post.dto.response.PostListResponse;
import com.study.dtopractice.bbs.post.dto.response.PostResponse;
import com.study.dtopractice.bbs.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Post", description = "게시글 관련 API")
@RestController
@RequestMapping("/bbs/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @Operation(
            summary = "게시글 등록",
            description = "게시글 등록. WRTIER_NO는 필수/ WRITER_NAME은 X"
    )
    @PostMapping
    public CreatePostResponse createPost(@Valid @RequestBody CreatePostRequest req){
        return postService.createPost(req);
    }

    @Operation(
            summary = "게시판별 게시글 목록 조회",
            description = "게시판ID를 통해 해당 게시판의 제목 및 간단한 정보 조회"
    )
    @GetMapping(path = "/all/{boardId}")
    public List<PostListResponse> getAllPosts(@PathVariable(name = "boardId") Long boardId){
        return postService.getAllPosts(boardId);
    }


    @Operation(
            summary = "게시글 조회",
            description = "POST_ID를 통해 해당 게시글의 상세내용 조회. viewCnt + 1"
    )
    @GetMapping(path = "/{postId}")
    public PostResponse getPost(@PathVariable(name = "postId") Long postId){
        return postService.getPost(postId);
    }
}
