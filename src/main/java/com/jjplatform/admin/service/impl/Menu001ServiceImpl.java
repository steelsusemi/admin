package com.jjplatform.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.dao.Menu001Dao;
import com.jjplatform.admin.service.Menu001Service;

@Service("menu001Service")
public class Menu001ServiceImpl implements Menu001Service {
	private static final Logger log = LoggerFactory.getLogger(Menu001ServiceImpl.class);
	
	@Autowired
	private Menu001Dao menu001Dao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> menuList(Map param) throws Exception {
		return menu001Dao.menuList(param);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int menuSave(List<Map> paramList) throws Exception {
		int rtnCnt = 0;
		
		for(Map param : paramList) {
			
			int saveCnt = "U".equals(param.get("rowStatus")) ? (int) param.get("menuSeq") : menu001Dao.selectMenuSeq();
			param.put("menuSeq", saveCnt);
			rtnCnt += menu001Dao.menuSave(param);
		}
		
		return rtnCnt;
	}

}
