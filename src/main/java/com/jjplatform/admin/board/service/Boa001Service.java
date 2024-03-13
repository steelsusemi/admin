package com.jjplatform.admin.board.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Boa001Service {
	
	public List<Map> selectBoardList(Map param) throws Exception;

	public int saveBoard(Map param) throws Exception;
}
