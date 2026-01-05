package com.study.dtopractice.bbs.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {
    @NotBlank(message = "게시판은 필수 입력입니다.")
    private Long boardId;

    @NotBlank(message = "제목은 필수 입력입니다.")
    @Size(min = 2, max = 100, message = "제목은 2글자 이상 100글자 이하만 입력 가능합니다.")

    private String title;
    private String content;
    private Long writerId;
    private String writerName;
}
