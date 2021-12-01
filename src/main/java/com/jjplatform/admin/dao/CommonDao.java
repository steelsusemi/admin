package com.jjplatform.admin.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.jjplatform.admin.vo.UserVo;

public class CommonDao<T> {
	
	@Autowired
    private SqlSessionTemplate sqlSession;
 
    @SuppressWarnings("rawtypes")
	public T selectOne(String xmlPath, Map param) {
        return sqlSession.selectOne(xmlPath, param);
    }
    
	public T selectOne(String xmlPath, String param) {
        return sqlSession.selectOne(xmlPath, param);
    }
    
    @SuppressWarnings("rawtypes")
	public List<T> selectList(String xmlPath, Map param) {
        return sqlSession.selectList(xmlPath, param);
    }
}