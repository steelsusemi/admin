package com.jjplatform.admin.adm.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Adm002Service {
	
	public List<Map> selectStockManageList(Map param) throws Exception;

	public int saveStockManage(List<Map> paramList) throws Exception;
}
