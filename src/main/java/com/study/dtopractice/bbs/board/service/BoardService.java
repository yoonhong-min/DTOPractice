package com.study.dtopractice.bbs.board.service;

import static com.study.dtopractice.global.exception.ErrorCode.BOARD_NOT_FOUND;
import static com.study.dtopractice.global.exception.ErrorCode.DUPLICATE_BOARD_CODE;
import static com.study.dtopractice.global.exception.ErrorCode.DUPLICATE_BOARD_NAME;

import com.study.dtopractice.bbs.board.dto.request.CreateBoardRequest;
import com.study.dtopractice.bbs.board.dto.request.UpdateBoardRequest;
import com.study.dtopractice.bbs.board.dto.response.BoardListResponse;
import com.study.dtopractice.bbs.board.dto.response.CreateBoardResponse;
import com.study.dtopractice.bbs.board.dto.response.UpdateBoardResponse;
import com.study.dtopractice.bbs.board.mapper.BoardMapper;
import com.study.dtopractice.bbs.board.domain.Board;
import com.study.dtopractice.global.exception.BusinessException;
import com.study.dtopractice.global.exception.ErrorCode;
import com.study.dtopractice.global.util.StringNormalizer;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    @Transactional
    public CreateBoardResponse createBoard(CreateBoardRequest request) {
        Board board = new Board();
        String normalizeCode = StringNormalizer.normalize(request.getBoardCode());
        String normalizeName = StringNormalizer.normalize(request.getBoardName());
        if(boardMapper.existBoardCode(normalizeCode)){
            throw new BusinessException(ErrorCode.DUPLICATE_BOARD_CODE);
        }
        if(boardMapper.existBoardName(normalizeName)){
            throw new BusinessException(ErrorCode.DUPLICATE_BOARD_NAME);
        }
        board.setBoardCode(normalizeCode);
        board.setBoardName(normalizeName);

        boardMapper.insertBoard(board);

        return CreateBoardResponse.from(board);
    }

    public List<BoardListResponse> getAllBoards(){
        return boardMapper.selectAllBoards()
                .stream()
                .map(board -> new BoardListResponse(
                        board.getBoardId(),
                        board.getBoardCode(),
                        board.getBoardName()
                ))
                .toList();
    }

    @Transactional
    public UpdateBoardResponse updateBoard(Long boardId, UpdateBoardRequest request) {
        Board board = boardMapper.selectById(boardId);
        if(board == null){
            throw new BusinessException(BOARD_NOT_FOUND);
        }

        if(request.getBoardCode() != null){
            String normalizeCode = StringNormalizer.normalize(request.getBoardCode());
            if(boardMapper.existsByCodeExceptId(boardId, normalizeCode)){
                throw new BusinessException(DUPLICATE_BOARD_CODE);
            }
            board.setNormalizedCode(normalizeCode);
            board.setBoardCode(request.getBoardCode());
        }
        if(request.getBoardName() != null){
            String normalizeName = StringNormalizer.normalize(request.getBoardName());
            if(boardMapper.existsByNameExceptId(boardId, normalizeName)){
                throw new BusinessException(DUPLICATE_BOARD_NAME);
            }
            board.setNormalizedName(normalizeName);
            board.setBoardName(request.getBoardName());
        }
        if(request.getUseYn() != null){
            validateUseYn(request.getUseYn());
            board.setUseYn(request.getUseYn());
        }

        int cnt = boardMapper.updateBoard(board);
        if(cnt == 0){
            throw new BusinessException(BOARD_NOT_FOUND);
        }

        return UpdateBoardResponse.from(board);
    }

    private void validateUseYn(String useYn) {
        if (!"Y".equals(useYn) && !"N".equals(useYn)) {
            throw new BusinessException(ErrorCode.INVALID_USE_YN);
        }
    }
}
