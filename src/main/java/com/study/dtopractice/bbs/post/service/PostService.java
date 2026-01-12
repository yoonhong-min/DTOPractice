package com.study.dtopractice.bbs.post.service;

import com.study.dtopractice.bbs.post.domain.Post;
import com.study.dtopractice.bbs.post.dto.request.CreatePostRequest;
import com.study.dtopractice.bbs.post.dto.response.CreatePostResponse;
import com.study.dtopractice.bbs.post.dto.response.PostListResponse;
import com.study.dtopractice.bbs.post.dto.response.PostResponse;
import com.study.dtopractice.bbs.post.mapper.PostMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    @Transactional
    public CreatePostResponse createPost(CreatePostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setBoardId(request.getBoardId());
        post.setWriterId(request.getWriterId());
        post.setWriterName(request.getWriterName());

        postMapper.createPost(post);
        return CreatePostResponse.from(post);
    }

    public List<PostListResponse> getAllPosts(Long boardId){
        return postMapper.getAllPosts(boardId)
                .stream()
                .map(post -> new PostListResponse(
                        post.getPostId(),
                        post.getBoardId(),
                        post.getTitle(),
                        post.getWriterId(),
                        post.getWriterName(),
                        post.getViewCnt()
                ))
                .toList();
    }

    @Transactional
    public PostResponse getPost(Long postId){
        postMapper.increaseViewCnt(postId);
        Post post = postMapper.getPost(postId);
        return PostResponse.from(post);
    }
}
