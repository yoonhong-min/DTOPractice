package com.study.dtopractice.bbs.post.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private Long postId;
    private Long boardId;
    private String title;
    private String content;
    private Long writerId;
    private String writerName;
    private int viewCnt;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
