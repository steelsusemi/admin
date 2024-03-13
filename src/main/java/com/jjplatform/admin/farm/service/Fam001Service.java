package com.jjplatform.admin.farm.service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface Fam001Service {
	
	public List<Map> selectVegetFarmList(Map param) throws Exception;

	public int saveVegetFarm(List<Map> paramList) throws Exception;
}
