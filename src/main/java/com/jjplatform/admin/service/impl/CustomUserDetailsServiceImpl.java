package com.jjplatform.admin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.aop.LoggerAspect;
import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.dao.UserAuthDAO;
import com.jjplatform.admin.vo.UserVo;

@Service("customUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl {
	private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Autowired
    private UserAuthDAO userAuthDAO;
 
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	List<UserVo> userAuthes = userAuthDAO.loadUserByUsername(username);
		
		if(userAuthes.size() == 0) {
			throw new UsernameNotFoundException("User "+username+" Not Found!");
		}
		
		return new CustomUserDetails(userAuthes);
    }

}
