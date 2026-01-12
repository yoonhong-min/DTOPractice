package com.study.dtopractice.bbs.post.dto.response;

import lombok.Getter;

@Getter
public class PostListResponse {
    private final Long postId;
    private final Long boardId;
    private final String title;
    private final Long writerId;
    private final String writerName;
    private final int viewCnt;


    public PostListResponse(Long postId, Long boardId, String title, Long writerId, String writerName, int viewCnt){
        this.boardId = boardId;
        this.postId = postId;
        this.title = title;
        this.writerId = writerId;
        this.writerName = writerName;
        this.viewCnt = viewCnt;
    }
}
