package com.jjplatform.admin.user.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jjplatform.admin.comm.vo.CustomUserDetails;

public interface CustomUserDetailsService {
 
    CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
