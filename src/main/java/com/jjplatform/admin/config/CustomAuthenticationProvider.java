package com.jjplatform.admin.config;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.service.impl.CustomUserDetailsServiceImpl;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	private static Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // 검쯩을 위한 구현
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String)authentication.getCredentials();
        
        log.info("username :: password => " + username + " : "+password+" : "+passwordEncoder.encode(password));

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // password 일치하지 않으면!
        if(userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("BadCredentialsException");
        }
     
        UsernamePasswordAuthenticationToken authenticationToken  = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        log.info("UsernamePasswordAuthenticationToken => " + authenticationToken);
        
        return authenticationToken;
    }

    // 토큰 타입과 일치할 때 인증
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
