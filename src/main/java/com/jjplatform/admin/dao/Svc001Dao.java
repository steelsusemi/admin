package com.jjplatform.admin.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jjplatform.admin.mapper.CommonMapper;

@SuppressWarnings("rawtypes")
@Repository("svc001Dao")
public class Svc001Dao extends CommonMapper {
	private static final Logger log = LoggerFactory.getLogger(Svc001Dao.class);
	
	private String NAME_SPACE = "svc001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> svcList(Map param) throws Exception {
    	log.info("22222222 >> " + param);
        return selectList(NAME_SPACE + "svcList", param);
    }

	@SuppressWarnings("unchecked")
	public int svcSave(Map param) {
		// TODO Auto-generated method stub
		return insert(NAME_SPACE + "svcSave", param);
	}

	public int selectSvcSeq() {
		// TODO Auto-generated method stub
		return (int) selectOne(NAME_SPACE + "selectSvcSeq", "");
	}
}
