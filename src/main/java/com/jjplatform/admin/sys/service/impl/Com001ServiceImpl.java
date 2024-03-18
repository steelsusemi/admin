package com.jjplatform.admin.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.sys.dao.Com001Dao;
import com.jjplatform.admin.sys.service.Com001Service;

@Service("com001Service")
public class Com001ServiceImpl implements Com001Service {
	private static final Logger log = LoggerFactory.getLogger(Com001ServiceImpl.class);
	
	@Autowired
	private Com001Dao com001Dao;

	@SuppressWarnings({ "rawtypes" })
	public List<Map> selectComMstList(Map param) throws Exception {
		return com001Dao.selectComMstList(param);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public List<Map> selectComDtlList(Map param) throws Exception {
		return com001Dao.selectComDtlList(param);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public int saveComList(List<Map> param) throws Exception {
		return com001Dao.saveComList(param);
	}
}
