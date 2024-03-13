package com.jjplatform.admin.comm.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface CommonService {
	
	public List<Map> selectLeftMenuList(Map param) throws Exception;
	
	public String selectServiceNm(Map param);

}
