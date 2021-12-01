package com.jjplatform.admin.dao;

import org.springframework.stereotype.Repository;

import com.jjplatform.admin.vo.UserVo;

@Repository
public class UserAuthDao extends CommonDao {
	
	private String NAME_SPACE = "com.jjplatform.admin.dao.UserAuthDao.";

	public UserVo loadUserByUsername(String username) {
        return (UserVo) selectOne(NAME_SPACE + "selectUserById", username);
    }
}
