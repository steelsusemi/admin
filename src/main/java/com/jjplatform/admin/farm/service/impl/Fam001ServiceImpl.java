package com.jjplatform.admin.farm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.farm.dao.Fam001Dao;
import com.jjplatform.admin.farm.service.Fam001Service;

@Service("fam001Service")
public class Fam001ServiceImpl implements Fam001Service {
	private static final Logger log = LoggerFactory.getLogger(Fam001ServiceImpl.class);
	
	@Autowired
	private Fam001Dao fam001Dao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> selectVegetFarmList(Map param) throws Exception {
		log.info("selectVegetFarmList >>>>>>>>>>>> " + param);
//		List<Map> aa = new ArrayList<Map>();
//		aa.add(param);
//		return aa;
//		param.put("currentPage", (int) param.get("currentPage") == 0 ? 0 : (int) param.get("currentPage") * (int) param.get("pageSize") + 1);
		return fam001Dao.selectVegetFarmList(param);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int saveVegetFarm(List<Map> paramList) throws Exception {
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
		rtnCnt += fam001Dao.saveVegetFarm(param);
		
		return rtnCnt;
	}

}
