package com.study.dtopractice.bbs.board.dto.response;

import com.study.dtopractice.bbs.board.domain.Board;
import lombok.Getter;

@Getter
public class CreateBoardResponse {
    private final Long boardId;
    private final String boardName;
    private final String boardCode;

    public CreateBoardResponse(Long boardId, String boardCode, String boardName) {
        this.boardId = boardId;
        this.boardCode = boardCode;
        this.boardName = boardName;
    }

    public static CreateBoardResponse from(Board board) {
        return new CreateBoardResponse(
                board.getBoardId(),
                board.getBoardCode(),
                board.getBoardName()
        );
    }
}
