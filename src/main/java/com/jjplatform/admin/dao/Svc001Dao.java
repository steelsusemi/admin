package com.jjplatform.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@SuppressWarnings("rawtypes")
@Repository("svc001Dao")
public class Svc001Dao extends CommonDao {
	
	private String NAME_SPACE = "com.jjplatform.admin.dao.Svc001Dao.";
 
    @SuppressWarnings({ "unchecked"})
	public List<Map> svcList(Map param) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
    	System.out.println("22222222 >> " + param);
        return selectList(NAME_SPACE + "svcList", param);
    }
}
