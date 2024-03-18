package com.jjplatform.admin.sys.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jjplatform.admin.comm.vo.CustomUserDetails;

public interface CustomUserDetailsService {
 
    CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
