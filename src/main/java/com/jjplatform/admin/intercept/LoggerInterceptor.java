package com.jjplatform.admin.intercept;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	log.info("#################[ LoggerInterceptor ]#################");
	   HttpSession sessInfo = request.getSession();
	   log.info("sessInfo >>>>>>>> "+sessInfo+" : "+sessInfo.getAttribute("userInfo")+" : "+request.getRequestURI()+" : "+request.getRequestURI().equals("/"));
	   String uri = request.getRequestURI();
	   uri = (uri.contains("/comm/")) ? uri.substring(0,6) : "";
	   UserVo userVo = (UserVo) sessInfo.getAttribute("userInfo");
	   log.info(uri + "<< >> "+userVo+" : "+"/comm/".equals(uri));
	   if(sessInfo == null || ("/comm/".equals(uri) && userVo == null)) {
		  sessInfo.invalidate();
		  sessInfo.setMaxInactiveInterval(0);
		  log.info("111111111111 >> " + sessInfo.getMaxInactiveInterval());
		  response.sendRedirect("/logout");
		  
		  return false;
       }
	   
	   log.info("=====================LoggerInterceptor Start=====================");
	   log.info("LocalDate.now() 		>> "+ LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
	   log.info("LocalDateTime.now() 	>> "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	   log.info("LocalDate.now() 		>> "+ LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
	   log.info("request.getMethod 		>> "+request.getMethod());
	   log.info("request.getContextPath >> "+request.getContextPath());
	   log.info("request.getRequestURI 	>> "+request.getRequestURI());
	   log.info("request.getRequestURL 	>> "+request.getRequestURL());
	   log.info("request.getLocalAddr 	>> "+request.getLocalAddr());
	   log.info("request.getServerName 	>> "+request.getServerName());
	   log.info("request.getServletPath >> "+request.getServletPath());
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
