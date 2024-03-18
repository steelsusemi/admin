package com.jjplatform.admin.sys.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Mnu001Service {
	
	public List<Map> selectMenuList(Map param) throws Exception;
	
	public String selectMenuId(String path);

	public int saveMenu(List<Map> paramList) throws Exception;
}
