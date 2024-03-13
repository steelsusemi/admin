package com.jjplatform.admin.svc.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Svc001Service {
	
	public List<Map> selectSvcMngList(Map param) throws Exception;

	public int saveSvc(List<Map> paramList) throws Exception;
}
