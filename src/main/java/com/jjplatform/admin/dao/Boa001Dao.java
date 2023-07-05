package com.jjplatform.admin.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository("boa001Dao")
public class Boa001Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Boa001Dao.class);
	
	private String NAME_SPACE = "boa001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectBoardList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectBoardList", param);
    }

	public int saveBoard(Map param) {
		return insert(NAME_SPACE + "saveBoard", param);
	}

	public int selectBoardSeq() {
		return (int) selectOne(NAME_SPACE + "selectBoardSeq", "");
	}
}
