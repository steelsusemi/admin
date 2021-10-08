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
import org.springframework.web.bind.annotation.GetMapping;

import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.vo.UserVo;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String root() {
        return "index";
    }

	@GetMapping("/main")
    public String main(HttpServletRequest request, HttpServletResponse respose, Authentication authentication) throws IOException {
    	log.info("###################[ Main Page 이동]###################");
    	log.info("authentication : " + authentication);
    	if (authentication != null) {
			log.info("타입정보 : " + authentication.getClass());
			
			// 세션 정보 객체 반환
			WebAuthenticationDetails web = (WebAuthenticationDetails)authentication.getDetails();
			log.info("세션ID : " + web.getSessionId());
			log.info("접속IP : " + web.getRemoteAddress());

			
			// UsernamePasswordAuthenticationToken에 넣었던 UserDetails 객체 반환
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			log.info("ID정보 : " + userDetails.getUserVo().get(0).getUserId()); 
			
			HttpSession sessInfo = request.getSession();
			UserVo userVo = (UserVo) sessInfo.getAttribute("userInfo");
			log.info("ID정보 : " + userVo); 
			if(userVo == null && request.getRequestURI().equals("/main")) {
				sessInfo.setAttribute("userInfo", userDetails.getUserVo().get(0));
				sessInfo.setMaxInactiveInterval(30);  // 60초
//				sessInfo.invalidate();
			}
			
			log.info("세션 정보 : " + sessInfo.getAttribute("userInfo")+" : "+request.getRequestURI());
		}
    	
//    	UserVo userInfo = (UserVo) request.getSession().getAttribute("userInfo");
//    	if(userInfo == null) {
//    		
//    	}
    	
        return "user/main";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
    	log.info("session => " + request.getSession());
        return "login";
    } 
    
    @GetMapping("/logout")
    public String loout() throws Exception {
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	if (auth != null) {
//    		new SecurityContextLogoutHandler().logout(request, response, auth);
//    	}

        return "login";
    }

    @GetMapping("/error")
    public String accessDenied() {
        return "error/access-denied";
    }

}
