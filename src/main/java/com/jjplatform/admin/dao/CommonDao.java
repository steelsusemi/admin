package com.jjplatform.admin.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository
public class CommonDao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(CommonDao.class);
	
	private String NAME_SPACE = "commonDao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectLeftMenuList(Map param) throws Exception {
    	log.info("22222222 >> " + param);
        return selectList(NAME_SPACE + "selectLeftMenuList", param);
    }

	public String selectServiceNm(Map param) {
		return (String) selectOne(NAME_SPACE + "selectServiceNm", param);
	}
}
