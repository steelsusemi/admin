package com.jjplatform.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.dao.Boa001Dao;
import com.jjplatform.admin.service.Boa001Service;

@Service("boa001Service")
public class Boa001ServiceImpl implements Boa001Service {
	private static final Logger log = LoggerFactory.getLogger(Boa001ServiceImpl.class);
	
	@Autowired
	private Boa001Dao boa001Dao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> selectBoardList(Map param) throws Exception {
//		log.info("1111111111111 >> " + param);
//		List<Map> aa = new ArrayList<Map>();
//		aa.add(param);
//		return aa;
//		param.put("currentPage", (int) param.get("currentPage") == 0 ? 0 : (int) param.get("currentPage") * (int) param.get("pageSize") + 1);
		return boa001Dao.selectBoardList(param);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int saveBoard(List<Map> paramList) throws Exception {
//		List<Map> aa = new ArrayList<Map>();
//		aa.add(param);
//		return aa;
//		int rtnCnt = 0;
//		
//		for(Map param : paramList) {
//			
//			int saveCnt = "U".equals(param.get("rowStatus")) ? (int) param.get("svcSeq") : boa001Dao.selectBoardSeq();
//			param.put("svcSeq", saveCnt);
//			rtnCnt += boa001Dao.svcSave(param);
//		}
		
		int rtnCnt = 0;
		log.info("paramList >> "+paramList);
		Map param = new HashMap();
		param.put("list", paramList);
		rtnCnt += boa001Dao.saveBoard(param);
		
		return rtnCnt;
	}

}
