package com.jjplatform.admin.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.vo.UserVo;

@Repository
public class UserAuthDAO {
	
	private String NAME_SPACE = "com.jjplatform.admin.dao.UserAuthDAO.";
	
	@Autowired
    private SqlSessionTemplate sqlSession;
 
    public UserVo loadUserByUsername(String username) {
        return sqlSession.selectOne(NAME_SPACE + "selectUserById", username);
    }
}
