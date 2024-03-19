package com.jjplatform.admin.sys.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository
public class Com001Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Com001Dao.class);
	
	private String NAME_SPACE = "com001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectComMstList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectComMstList", param);
    }
    
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectComDtlList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectComDtlList", param);
    }

	@SuppressWarnings("unchecked")
	public int saveComList(List<Map> param) throws Exception {
		return (int) insert(NAME_SPACE + "saveComList", param);
	}
	
	@SuppressWarnings("unchecked")
	public int saveComDtlList(List<Map> param) throws Exception {
		return (int) insert(NAME_SPACE + "saveComDtlList", param);
	}
}
