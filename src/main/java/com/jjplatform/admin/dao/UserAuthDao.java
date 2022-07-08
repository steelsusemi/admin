package com.jjplatform.admin.dao;

import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;
import com.jjplatform.admin.vo.UserVo;

@SuppressWarnings("rawtypes")
@Repository
public class UserAuthDao extends CommonMapper {
	
	private String NAME_SPACE = "userAuthDao.";

	public UserVo loadUserByUsername(String username) {
        return (UserVo) selectOne(NAME_SPACE + "selectUserById", username);
    }
}
