package com.study.dtopractice.bbs.board.dto.response;

import lombok.Getter;

@Getter
public class BoardListResponse {
    private final Long boardId;
    private final String boardName;
    private final String boardCode;

    public BoardListResponse(Long boardId, String boardName, String boardCode) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.boardCode = boardCode;
    }
}
