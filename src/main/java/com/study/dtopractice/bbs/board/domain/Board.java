package com.study.dtopractice.bbs.board.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private Long boardId;
    private String boardCode;
    private String boardName;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String normalizedCode;
    private String normalizedName;
}
