package com.jjplatform.admin.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFailureHandler implements AuthenticationFailureHandler {
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
			
//		String username = request.getParameter("");
//        String password = request.getParameter(loginpwdname);
//        String errormsg = null;
        
//        if(exception instanceof BadCredentialsException) {
//            errormsg = MessageUtils.getMessage("error.BadCredentials");
//        } else if(exception instanceof InternalAuthenticationServiceException) {
//            errormsg = MessageUtils.getMessage("error.BadCredentials");
//        } else if(exception instanceof DisabledException) {
//            errormsg = MessageUtils.getMessage("error.Disaled");
//        } else if(exception instanceof CredentialsExpiredException) {
//            errormsg = MessageUtils.getMessage("error.CredentialsExpired");
//        }
        
//        request.setAttribute(loginidname, username);
//        request.setAttribute(loginpwdname, password);
//        request.setAttribute(errormsgname, errormsg);
// 
//        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
		System.out.println("errormsg >>>>>>>>>>>>>>>>  "+ exception.getMessage());
	}
}
