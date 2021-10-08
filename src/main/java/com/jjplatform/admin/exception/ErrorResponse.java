package com.jjplatform.admin.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
//	private String messageKey;
//    private String locale;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ErrorResponse cacheKeys = (ErrorResponse) o;
//        return Objects.equals(messageKey, cacheKeys.messageKey) &&
//                Objects.equals(locale, cacheKeys.locale);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(messageKey, locale);
//    }
    
    private String message;
    private String code;
    private int status;
    private String detail;

    public ErrorResponse(ErrorCode code) {
      this.message = code.getMessage();
      this.status = code.getStatus();
      this.code = code.getCode();
      this.detail = code.getDetail();
    }

    public static ErrorResponse of(ErrorCode code) {
      return new ErrorResponse(code);
    }
}
