package com.study.dtopractice.bbs.post.dto.response;

import com.study.dtopractice.bbs.post.domain.Post;
import lombok.Getter;

@Getter
public class CreatePostResponse {
    private final Long postId;
    private final String title;
    private final Long writerId;
    private final String writerName;

    public CreatePostResponse(Long postId, String title, Long writerId, String writerName) {
        this.postId = postId;
        this.title = title;
        this.writerId = writerId;
        this.writerName = writerName;
    }

    public static CreatePostResponse from(Post post) {
        return new CreatePostResponse(
                post.getPostId(),
                post.getTitle(),
                post.getWriterId(),
                post.getWriterName()
        );
    }
}
