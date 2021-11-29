package com.jjplatform.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.vo.UserVo;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String root(Authentication authentication) {
    	if (authentication != null) {
    		return "main/main";
    	}
    	
        return "user/login";
    }

	@GetMapping("/main")
    public String main(HttpServletRequest request, HttpServletResponse respose, Authentication authentication, Model model) throws IOException {
    	log.info("###################[ Main Page 이동]###################");
//    	if(true) {
//    		throw new CustomException(ErrorCode.TEMPORARY_SERVER_ERROR);
//    	}
    	
    	log.info("authentication : " + authentication);
    	if (authentication != null) {
			log.info("타입정보 : " + authentication.getClass());
			
			// 세션 정보 객체 반환
			WebAuthenticationDetails web = (WebAuthenticationDetails)authentication.getDetails();
			log.info("세션ID : " + web.getSessionId());
			log.info("접속IP : " + web.getRemoteAddress());

			
			// UsernamePasswordAuthenticationToken에 넣었던 UserDetails 객체 반환
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//			log.info("ID정보 : " + userDetails.getUserVo().get(0).getUserId()); 
			log.info("ID정보 : " + userDetails.getUserVo().getUserId()); 
			
			HttpSession sessInfo = request.getSession();
			UserVo userVo = (UserVo) sessInfo.getAttribute("userInfo");
			log.info("ID정보 : " + userVo); 
			if(userVo == null && request.getRequestURI().equals("/main")) {
				sessInfo.setAttribute("userInfo", userDetails.getUserVo());
				sessInfo.setMaxInactiveInterval(300);  // 60초
//				sessInfo.invalidate();
			}
			
			log.info("세션 정보 : " + sessInfo.getAttribute("userInfo")+" : "+request.getRequestURI());
		}
    	
//    	UserVo userInfo = (UserVo) request.getSession().getAttribute("userInfo");
//    	if(userInfo == null) {
//    		
//    	}
    	
        return "main/main";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        return "user/login";
    } 
    
    @GetMapping("/logout")
    public String loout() throws Exception {
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();                                                                                                                                                                                                                                                                                                                                                                                                                              
//    	if (auth != null) {
//    		new SecurityContextLogoutHandler().logout(request, response, auth);
//    	}

        return "user/login";
    }

    @GetMapping("/error")
    public String accessDenied() {
        return "error/access-denied";
    }
    
    @GetMapping("/board")
    public String board() {
        return "board/board";
    }
    
    @GetMapping("/menuList")
    public String menuList() {
        return "com/menuList";
    }
    
    @GetMapping("/main1")
    public String main1(){
    	return "main/main1";
    }
    
    @GetMapping("/main2")
    public String main2(){
    	return "main/main2";
    }
    
    @GetMapping("/main3")
    public String main3(){
    	return "main/main3";
    }

}
