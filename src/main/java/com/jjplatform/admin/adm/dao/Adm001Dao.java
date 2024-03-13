package com.jjplatform.admin.adm.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository("adm001Dao")
public class Adm001Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Adm001Dao.class);
	
	private String NAME_SPACE = "adm001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectStockInOutList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectStockInOutList", param);
    }

	public int saveStockInOut(Map param) {
		return insert(NAME_SPACE + "saveStockInOut", param);
	}
}
