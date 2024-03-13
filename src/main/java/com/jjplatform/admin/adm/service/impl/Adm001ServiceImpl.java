package com.jjplatform.admin.adm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.adm.dao.Adm001Dao;
import com.jjplatform.admin.adm.service.Adm001Service;

@Service("adm001Service")
public class Adm001ServiceImpl implements Adm001Service {
	private static final Logger log = LoggerFactory.getLogger(Adm001ServiceImpl.class);
	
	@Autowired
	private Adm001Dao adm001Dao;

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List<Map> selectStockInOutList(Map param) throws Exception {
		return adm001Dao.selectStockInOutList(param);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int saveStockInOut(List<Map> paramList) throws Exception {
		int rtnCnt = 0;
		log.info("paramList >> "+paramList);
		Map param = new HashMap();
		param.put("list", paramList);
		
		rtnCnt += adm001Dao.saveStockInOut(param);
		
		return rtnCnt;
	}

}
