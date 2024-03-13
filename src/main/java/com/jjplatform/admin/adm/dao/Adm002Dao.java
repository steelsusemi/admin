package com.jjplatform.admin.adm.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository("adm002Dao")
public class Adm002Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Adm002Dao.class);
	
	private String NAME_SPACE = "adm002Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectStockManageList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectStockManageList", param);
    }

	public int saveStockManage(Map param) {
		return insert(NAME_SPACE + "saveStockManage", param);
	}
}
