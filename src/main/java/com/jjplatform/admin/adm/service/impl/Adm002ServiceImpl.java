package com.jjplatform.admin.adm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.adm.dao.Adm002Dao;
import com.jjplatform.admin.adm.service.Adm002Service;

@Service("adm002Service")
public class Adm002ServiceImpl implements Adm002Service {
	private static final Logger log = LoggerFactory.getLogger(Adm002ServiceImpl.class);
	
	@Autowired
	private Adm002Dao adm002Dao;

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List<Map> selectStockManageList(Map param) throws Exception {
		return adm002Dao.selectStockManageList(param);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int saveStockManage(List<Map> paramList) throws Exception {
		int rtnCnt = 0;
		log.info("paramList >> "+paramList);
		Map param = new HashMap();
		param.put("list", paramList);
		
		rtnCnt += adm002Dao.saveStockManage(param);
		return rtnCnt;
	}

}
