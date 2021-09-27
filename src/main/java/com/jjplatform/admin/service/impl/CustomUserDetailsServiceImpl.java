package com.jjplatform.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.dao.UserAuthDAO;
import com.jjplatform.admin.vo.CustomUserDetails;
import com.jjplatform.admin.vo.UserVo;

@Service("customUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl {
	
	@Autowired
    private UserAuthDAO userAuthDAO;
 
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	List<UserVo> userAuthes = userAuthDAO.loadUserByUsername(username);
		System.out.println("userAuthes size : "+userAuthes.size());
		
		if(userAuthes.size() == 0) {
			throw new UsernameNotFoundException("User "+username+" Not Found!");
		}
		
		return new CustomUserDetails(userAuthes);
    }

}
