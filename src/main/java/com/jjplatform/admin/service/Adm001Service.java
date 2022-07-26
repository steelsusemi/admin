package com.jjplatform.admin.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Adm001Service {
	
	public List<Map> selectStockInOutList(Map param) throws Exception;

	public int saveStockInOut(List<Map> paramList) throws Exception;
}
