package com.study.dtopractice.bbs.board.controller;

import com.study.dtopractice.bbs.board.dto.request.CreateBoardRequest;
import com.study.dtopractice.bbs.board.dto.request.UpdateBoardRequest;
import com.study.dtopractice.bbs.board.dto.response.BoardListResponse;
import com.study.dtopractice.bbs.board.dto.response.CreateBoardResponse;
import com.study.dtopractice.bbs.board.dto.response.UpdateBoardResponse;
import com.study.dtopractice.bbs.board.service.BoardService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbs/board")
@RequiredArgsConstructor
public class BaordController {
    private final BoardService boardService;

    @PostMapping
    public CreateBoardResponse createBoard(@Valid @RequestBody CreateBoardRequest request) {
        return boardService.createBoard(request);
    }

    @GetMapping
    public List<BoardListResponse> getBoards() {
        return boardService.getAllBoards();
    }

    @PatchMapping(path = "/{boardId}")
    public UpdateBoardResponse updateBoard(@PathVariable Long boardId,
            @RequestBody UpdateBoardRequest request){
        return boardService.updateBoard(boardId, request);
    }
}
