package com.jjplatform.admin.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 액세스 거부 처리기를 만듭니다. 
 * 이 핸들러에서 충분한 권한이 없는 보호된 리소스에 액세스하려는 사용자를 기록하고 요청을 로 리디렉션합니다 
 * /access-denied.
 * @author 제이제이천
 *
 */
@Component
public class LoggingAccessDeniedHandler implements AccessDeniedHandler{
	private static Logger log = LoggerFactory.getLogger(LoggingAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            log.info(auth.getPrincipal() + " was trying to access protected resource: " + request.getRequestURI());
//            response.sendRedirect(request.getContextPath() + "/main");
        }else {
        	response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
