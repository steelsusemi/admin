package com.jjplatform.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.dao.Svc001Dao;
import com.jjplatform.admin.service.Svc001Service;

@Service("svc001Service")
public class Svc001ServiceImpl implements Svc001Service {
	private static final Logger log = LoggerFactory.getLogger(Svc001ServiceImpl.class);
	
	@Autowired
	private Svc001Dao svc001Dao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> selectSvcMngList(Map param) throws Exception {
//		log.info("1111111111111 >> " + param);
//		List<Map> aa = new ArrayList<Map>();
//		aa.add(param);
//		return aa;
//		param.put("currentPage", (int) param.get("currentPage") == 0 ? 0 : (int) param.get("currentPage") * (int) param.get("pageSize") + 1);
		return svc001Dao.selectSvcMngList(param);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int saveSvc(List<Map> paramList) throws Exception {
//		List<Map> aa = new ArrayList<Map>();
//		aa.add(param);
//		return aa;
//		int rtnCnt = 0;
//		
//		for(Map param : paramList) {
//			
//			int saveCnt = "U".equals(param.get("rowStatus")) ? (int) param.get("svcSeq") : svc001Dao.selectSvcSeq();
//			param.put("svcSeq", saveCnt);
//			rtnCnt += svc001Dao.svcSave(param);
//		}
		
		int rtnCnt = 0;
		log.info("paramList >> "+paramList);
		Map param = new HashMap();
		param.put("list", paramList);
		rtnCnt += svc001Dao.saveSvc(param);
		
		return rtnCnt;
	}

}
