package com.study.dtopractice.bbs.board.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBoardRequest {
    @Size(min = 2, max = 50, message = "게시판명은 최소 2글자, 최대 50글자입니다.")
    private String boardName;
    @Size(min = 2, max = 50, message = "게시판 코드는 최소 2글자, 최대 50글자입니다.")
    private String boardCode;
    private String useYn;
}
