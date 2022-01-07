package com.jjplatform.admin.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Menu001Service {
	
	public List<Map> menuList(Map param) throws Exception;

	public int menuSave(List<Map> paramList) throws Exception;
}
