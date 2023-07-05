package com.jjplatform.admin.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Boa001Service {
	
	public List<Map> selectBoardList(Map param) throws Exception;

	public int saveBoard(List<Map> paramList) throws Exception;
}
