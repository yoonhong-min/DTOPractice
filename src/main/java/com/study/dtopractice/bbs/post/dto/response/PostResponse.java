package com.study.dtopractice.bbs.post.dto.response;

import com.study.dtopractice.bbs.post.domain.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private final Long postId;
    private final Long boardId;
    private final String title;
    private final Long writerId;
    private final String writerName;
    private final int viewCnt;
    private final String content;
    private final String createdAt;

    public PostResponse(Long postId, Long boardId, String title, Long writerId, String writerName, int viewCnt, String content, String createdAt){
        this.postId = postId;
        this.boardId = boardId;
        this.title = title;
        this.writerId = writerId;
        this.writerName = writerName;
        this.viewCnt = viewCnt;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static PostResponse from(Post post){
        return new PostResponse(
                post.getPostId(),
                post.getBoardId(),
                post.getTitle(),
                post.getWriterId(),
                post.getWriterName(),
                post.getViewCnt(),
                post.getContent(),
                post.getCreatedAt().toString()
        );
    }
}
