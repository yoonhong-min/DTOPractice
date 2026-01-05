package com.study.dtopractice.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    DUPLICATE_BOARD_CODE(HttpStatus.CONFLICT, "BBS_001", "이미 존재하는 게시판 코드입니다."),
    DUPLICATE_BOARD_NAME(HttpStatus.CONFLICT, "BBS_002", "이미 존재하는 게시판명입니다."),
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "BBS_003","존재하지 않는 게시판입니다."),
    INVALID_USE_YN(HttpStatus.BAD_REQUEST,"BBS_004"," useYn은 'Y' 또는 'N'만 허용됩니다."),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SYS_001", "서버 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() { return status; }
    public String getCode() { return code; }
    public String getMessage() { return message; }
}
