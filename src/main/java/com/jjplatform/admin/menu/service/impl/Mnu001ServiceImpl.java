package com.jjplatform.admin.menu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.menu.dao.Mnu001Dao;
import com.jjplatform.admin.menu.service.Mnu001Service;

@Service("mnu001Service")
public class Mnu001ServiceImpl implements Mnu001Service {
	private static final Logger log = LoggerFactory.getLogger(Mnu001ServiceImpl.class);
	
	@Autowired
	private Mnu001Dao mnu001Dao;

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List<Map> selectMenuList(Map param) throws Exception {
		return mnu001Dao.selectMenuList(param);
	}
	
	@Override
	public String selectMenuId(String menuId) {
		return mnu001Dao.selectMenuId(menuId);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int saveMenu(List<Map> paramList) throws Exception {
		int rtnCnt = 0;
		log.info("paramList >> "+paramList);
		Map param = new HashMap();
		param.put("list", paramList);
//		for(Map param : paramList) {
//			int saveCnt = "U".equals(param.get("rowStatus")) ? (int) param.get("menuSeq") : mnu001Dao.selectMenuSeq(param);
//			param.put("menuSeq", saveCnt);
//			log.info("param >> "+param);
			rtnCnt += mnu001Dao.saveMenu(param);
//		}
		
		return rtnCnt;
	}

}
