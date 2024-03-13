package com.jjplatform.admin.farm.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository("fam001Dao")
public class Fam001Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Fam001Dao.class);
	
	private String NAME_SPACE = "fam001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> selectVegetFarmList(Map param) throws Exception {
        return selectList(NAME_SPACE + "selectVegetFarmList", param);
    }

	public int saveVegetFarm(Map param) {
		return insert(NAME_SPACE + "saveVegetFarm", param);
	}

	public int selectSvcSeq() {
		return (int) selectOne(NAME_SPACE + "selectSvcSeq", "");
	}
}
