package com.jjplatform.admin.exception;

import java.util.Locale;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	  protected ResponseEntity<ErrorResponse> handleException(Exception e) {
	    ErrorResponse response = ErrorResponse.of(ErrorCode.TEMPORARY_SERVER_ERROR);
	    response.setDetail(e.getMessage());
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	  }
	  
	  @org.springframework.web.bind.annotation.ExceptionHandler(value = NoSuchElementException.class)
	  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	  protected ResponseEntity<ErrorResponse> handleNoSuchElementException(Exception e) {
	    ErrorResponse response = ErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND);
	    response.setDetail(e.getMessage());
	    return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	  }
	  
	  //요 밑으로 쭉쭉 추가적인 ExceptionHandler들을 추가해서 처리합니다
	  /* Custom Error Handler */
	  @org.springframework.web.bind.annotation.ExceptionHandler(value = CustomException.class)
	  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	  protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
	    ErrorResponse response = ErrorResponse.of(e.getErrorCode());
	    response.setDetail(e.getMessage());
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	  }
}
