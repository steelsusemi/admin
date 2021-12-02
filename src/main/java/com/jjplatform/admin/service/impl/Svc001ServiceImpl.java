package com.jjplatform.admin.service.impl;

import java.util.ArrayList;
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

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> svcList(Map param) throws Exception {
//		log.info("1111111111111 >> " + param);
//		List<Map> aa = new ArrayList<Map>();
//		aa.add(param);
//		return aa;
		return svc001Dao.svcList(param);
	}

}
