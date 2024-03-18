package com.jjplatform.admin.sys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.sys.dao.UserAuthDao;
import com.jjplatform.admin.vo.UserVo;

@Service("customUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl {
	private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
	
	@Autowired
    private UserAuthDao userAuthDAO;
 
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserVo userAuthes = (UserVo) userAuthDAO.loadUserByUsername(username);
		
		if(userAuthes == null) {
			throw new UsernameNotFoundException("User "+username+" Not Found!");
		}
		
		return new CustomUserDetails(userAuthes);
    }

}
