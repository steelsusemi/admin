package com.jjplatform.admin.sys.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository("mnu001Dao")
public class Mnu001Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Mnu001Dao.class);
	
	private String NAME_SPACE = "mnu001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectMenuList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectMenuList", param);
    }
    
    public String selectMenuId(String menuId) {
    	return (String) selectOne(NAME_SPACE + "selectMenuId", menuId);
	}
    
	public int saveMenu(Map param) {
		return insert(NAME_SPACE + "saveMenu", param);
	}

	public int selectMenuSeq(Map param) {
		return (int) selectOne(NAME_SPACE + "selectMenuSeq", param);
	}
}
