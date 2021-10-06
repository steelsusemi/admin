package com.jjplatform.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jjplatform.admin.vo.UserVo;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/main")
    public String main(HttpServletRequest request, HttpServletResponse respose) throws IOException {
    	log.info("###################[ Main Page 이동]###################");
    	
    	UserVo userInfo = (UserVo) request.getSession().getAttribute("userInfo");
    	if(userInfo == null) {
    		
    	}
    	
        return "user/main";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
    	System.out.println("session => " + request.getSession());
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
