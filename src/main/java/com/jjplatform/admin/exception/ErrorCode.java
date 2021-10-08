package com.jjplatform.admin.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum ErrorCode implements EnumModel {
	/* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST.value(), "C001", "리프레시 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(HttpStatus.BAD_REQUEST.value(), "C002", "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    CANNOT_FOLLOW_MYSELF(HttpStatus.BAD_REQUEST.value(), "C003", "자기 자신은 팔로우 할 수 없습니다"),
    INVALID_CODE(HttpStatus.BAD_REQUEST.value(), "C004", "Invalid Code"),
    EXPIRED_CODE(HttpStatus.BAD_REQUEST.value(), "C005", "Expired Code"),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED.value(), "C006", "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_MEMBER(HttpStatus.UNAUTHORIZED.value(), "C007", "현재 내 계정 정보가 존재하지 않습니다"),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "C008", "해당 유저 정보를 찾을 수 없습니다"),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "C009", "로그아웃 된 사용자입니다"),
    NOT_FOLLOW(HttpStatus.NOT_FOUND.value(), "C010.", "팔로우 중이지 않습니다"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "C011", "Resource not found"),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT.value(), "C012", "데이터가 이미 존재합니다"),
    
    /* 서버 에러 */
    TEMPORARY_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "500", "서버에 오류가 발생하여 요청을 수행할 수 없다."),
    
    ;
	
    private int status;
    private String code;
    private String message;
    private String detail;

    private ErrorCode(int status, String code, String message) {
      this.status = status;
      this.message = message;
      this.code = code;
    }
    
    @Override
    public String getKey() {
      return this.code;
    }

    @Override
    public String getValue() {
      return this.message;
    }
}
