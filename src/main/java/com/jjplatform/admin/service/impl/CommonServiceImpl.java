package com.jjplatform.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.dao.CommonDao;
import com.jjplatform.admin.service.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	private static final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);
	
	@Autowired
	private CommonDao commonDao;

	@SuppressWarnings({ "rawtypes" })
	public List<Map> selectLeftMenuList(Map param) throws Exception {
		return commonDao.selectLeftMenuList(param);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public String selectServiceNm(Map param) {
		return commonDao.selectServiceNm(param);
	}
}
