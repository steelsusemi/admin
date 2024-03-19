package com.jjplatform.admin.sys.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Com001Service {
	
	public List<Map> selectComMstList(Map param) throws Exception;
	
	public List<Map> selectComDtlList(Map param) throws Exception;

	public int saveComList(Map param) throws Exception;
	
	public int saveComList(List<Map> paramList) throws Exception;
	
	public int saveComDtlList(List<Map> paramList) throws Exception;
}
