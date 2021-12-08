package com.jjplatform.admin.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Svc001Service {
	
	public List<Map> svcList(Map param) throws Exception;

	public int svcSave(List<Map> paramList) throws Exception;
}
