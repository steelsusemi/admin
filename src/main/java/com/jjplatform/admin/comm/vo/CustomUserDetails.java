package com.jjplatform.admin.comm.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jjplatform.admin.vo.UserVo;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {
	
	public UserVo userVo;
	private boolean enabled;
	
	public CustomUserDetails(UserVo userAuthes) {
		this.userVo = userAuthes;
	}
	
    // 계정이 갖고있는 권한 목록을 리턴한다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        
//        for(int x=0; x<userVo.size(); x++) {
//        	roles.add(new SimpleGrantedAuthority(userVo.get(x).getUserRole()));
//		}
        
        roles.add(new SimpleGrantedAuthority(userVo.getUserRole()));
        
        return roles;
    }
    
    @Override
	public String getPassword() { //유저 비밀번호

		return userVo.getUserPass();
	}

	@Override
	public String getUsername() {// 유저 이름 혹은 아이디

		return userVo.getUserNm();
	}
 
    // 계정이 만료되지 않았는 지 리턴한다. (true: 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    // 계정이 잠겨있지 않았는 지 리턴한다. (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    // 비밀번호가 만료되지 않았는 지 리턴한다. (true: 만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    // 계정이 활성화(사용가능)인 지 리턴한다. (true: 활성화)
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
