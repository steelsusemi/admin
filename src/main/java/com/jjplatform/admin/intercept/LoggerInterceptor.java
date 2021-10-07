package com.jjplatform.admin.intercept;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jjplatform.admin.vo.UserVo;

public class LoggerInterceptor implements HandlerInterceptor{
	private static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		UserVo userInfo = (UserVo) request.getSession().getAttribute("userInfo");
//    	if(userInfo == null && !request.getRequestURI().equals("/main")) {
//    		request.getSession().invalidate();
//    		response.sendRedirect("/login");
//    	}
	   log.info("=====================LoggerInterceptor Start=====================");
	   log.info("Around LocalDate.now() >> "+ LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
	   log.info("Around LocalDateTime.now() >> "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	   log.info("Around LocalDate.now() >> "+ LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
	   log.info("Around request.getMethod >> "+request.getMethod());
	   log.info("Around request.getContextPath >> "+request.getContextPath());
	   log.info("Around request.getRequestURI >> "+request.getRequestURI());
	   log.info("Around request.getRequestURL >> "+request.getRequestURL());
	   log.info("Around request.getLocalAddr >> "+request.getLocalAddr());
	   log.info("Around request.getServerName >> "+request.getServerName());
	   log.info("Around request.getServletPath >> "+request.getServletPath());
	   log.info("=====================LoggerInterceptor End=====================");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		log.info("=====================LoggerInterceptor postHandle Logging Start=====================");
        log.info("=====================LoggerInterceptor postHandle Logging END=====================");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, @Nullable Exception arg3) throws Exception {
		log.info("=====================LoggerInterceptor afterCompletion Logging Start=====================");
        log.info("=====================LoggerInterceptorafterCompletion Logging END=====================");
	}
}
