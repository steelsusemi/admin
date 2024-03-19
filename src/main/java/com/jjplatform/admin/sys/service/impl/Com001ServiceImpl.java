package com.jjplatform.admin.sys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplatform.admin.sys.dao.Com001Dao;
import com.jjplatform.admin.sys.service.Com001Service;

import kr.co.shineware.util.common.string.StringUtil;

@Service("com001Service")
public class Com001ServiceImpl implements Com001Service {
	private static final Logger log = LoggerFactory.getLogger(Com001ServiceImpl.class);
	
	@Autowired
	private Com001Dao com001Dao;

	@SuppressWarnings({ "rawtypes" })
	public List<Map> selectComMstList(Map param) throws Exception {
		log.info("selectComMstList >>>>>> " + param);
		return com001Dao.selectComMstList(param);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public List<Map> selectComDtlList(Map param) throws Exception {
		return com001Dao.selectComDtlList(param);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public int saveComList(List<Map> param) throws Exception {
		log.info("saveComList >> "+param);
		return com001Dao.saveComList(param);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public int saveComDtlList(List<Map> param) throws Exception {
		log.info("saveComDtlList >> "+param);
		return com001Dao.saveComDtlList(param);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int saveComList(Map param) throws Exception {
		log.info("saveComList >> "+param);
		List<Map> mList = ((List<Map>) param.get("list")).stream().filter(m -> StringUtils.isNoneEmpty((String) m.get("grpCd"))).collect(Collectors.toList());
		log.info("mList >> "+mList);
		int mCnt = (mList.size() == 0) ? 0 : com001Dao.saveComList(mList);
		
		List<Map> dList = ((List<Map>) param.get("dtlList")).stream().filter(m -> StringUtils.isNoneEmpty((String) m.get("commCd"))).collect(Collectors.toList());
		log.info("dList >> "+dList);
		int dCnt = (dList.size() == 0) ? 0 : com001Dao.saveComDtlList(dList);
		return (mList.size() == 0) ? mCnt : dCnt;
	}
}
