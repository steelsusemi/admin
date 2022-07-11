package com.jjplatform.admin.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository("menu001Dao")
public class Menu001Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Menu001Dao.class);
	
	private String NAME_SPACE = "menu001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectMenuList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectMenuList", param);
    }

	public int saveMenu(Map param) {
		return insert(NAME_SPACE + "saveMenu", param);
	}

	public int selectMenuSeq() {
		return (int) selectOne(NAME_SPACE + "selectMenuSeq", "");
	}
}
