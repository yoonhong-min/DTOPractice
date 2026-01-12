package com.study.dtopractice.bbs.board.controller;

import com.study.dtopractice.bbs.board.dto.request.CreateBoardRequest;
import com.study.dtopractice.bbs.board.dto.request.UpdateBoardRequest;
import com.study.dtopractice.bbs.board.dto.response.BoardListResponse;
import com.study.dtopractice.bbs.board.dto.response.CreateBoardResponse;
import com.study.dtopractice.bbs.board.dto.response.UpdateBoardResponse;
import com.study.dtopractice.bbs.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Board", description = "게시판 관련 API")
@RestController
@RequestMapping("/bbs/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(
            summary = "게시판 등록"
    )
    @PostMapping
    public CreateBoardResponse createBoard(@Valid @RequestBody CreateBoardRequest request) {
        return boardService.createBoard(request);
    }

    @Operation(
            summary = "게시판 목록 조회"
    )
    @GetMapping
    public List<BoardListResponse> getBoards() {
        return boardService.getAllBoards();
    }

    @Operation(
            summary = "게시판 수정",
            description = "게시판명, 게시판코드, 사용여부 수정"
    )
    @PatchMapping(path = "/{boardId}")
    public UpdateBoardResponse updateBoard(@PathVariable Long boardId,
            @RequestBody UpdateBoardRequest request){
        return boardService.updateBoard(boardId, request);
    }
}
