package com.study.dtopractice.bbs.board.mapper;

import com.study.dtopractice.bbs.board.domain.Board;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface BoardMapper {
    int insertBoard(Board board);
    List<Board> selectAllBoards();
    Boolean existBoardName(String boardName);
    Boolean existBoardCode(String boardCode);
    Board selectById(Long boardId);
    Boolean existsByCodeExceptId(@Param("boardId") Long boardId, @Param("code") String normalizedCode);
    Boolean existsByNameExceptId(@Param("boardId") Long boardId, @Param("name") String normalizedName);
    int updateBoard(Board board);
}
