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
	public List<Map> menuList(Map param) throws Exception {
    	log.info("22222222 >> " + param);
        return selectList(NAME_SPACE + "menuList", param);
    }

	public int menuSave(Map param) {
		// TODO Auto-generated method stub
		return insert(NAME_SPACE + "menuSave", param);
	}

	public int selectMenuSeq() {
		return (int) selectOne(NAME_SPACE + "selectMenuSeq", "");
	}
}
