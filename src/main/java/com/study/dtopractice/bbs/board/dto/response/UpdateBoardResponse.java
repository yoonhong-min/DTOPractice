package com.study.dtopractice.bbs.board.dto.response;

import com.study.dtopractice.bbs.board.domain.Board;
import lombok.Getter;

@Getter
public class UpdateBoardResponse {
    private final Long boardId;
    private final String boardName;
    private final String boardCode;
    private final String useYn;

    public UpdateBoardResponse(Long boardId, String boardCode, String boardName, String useYn) {
        this.boardId = boardId;
        this.boardCode = boardCode;
        this.boardName = boardName;
        this.useYn = useYn;
    }

    public static UpdateBoardResponse from(Board board) {
        return new UpdateBoardResponse(
                board.getBoardId(),
                board.getBoardCode(),
                board.getBoardName(),
                board.getUseYn()
        );
    }
}
