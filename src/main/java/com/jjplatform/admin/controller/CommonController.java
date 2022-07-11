package com.jjplatform.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jjplatform.admin.config.ApplicationContextProvider;


@Controller
public class CommonController {
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
    @GetMapping("/{v1}")
    public String commonMenuMove(@PathVariable(value = "v1") String path) {
    	log.info("commonMenuMove => " + path);
    	String v1 = "";
    	path = path.toUpperCase();
    	
    	if(path.contains("MNU")) {
    		v1 = "sys";
    	}else if(path.contains("USR")) {
    		v1 = "user";
    	}else {
    		v1 = path.substring(0, path.length() - 4);
    	}
    	log.info("path >> " +path + " : "+ v1.toLowerCase());
    	
    	return v1.toLowerCase() + "/" + path;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked"})
	@PostMapping("/comm/{actNm}")
    public ResponseEntity<?> commonList(@RequestBody Map param, @PathVariable(value = "actNm") String actNm) {
    	String menuId = (String) param.get("menuId");
    	log.info("menuId => " + menuId + " : " + actNm);
    	String service = "";
    	if("leftMenu".equals(menuId)) {
    		service = "commonService";
    	}else if("MNU001M".equals(menuId)) {
    		service = "menu001Service";
    	}

    	List<?> resultList = new ArrayList();
    	Map rtnMap = new HashMap();
		try {
			Object tClass = ApplicationContextProvider.getContext().getBean(service);
			log.info("actNm => " + actNm.indexOf("select")+ " : " + actNm);
			if(actNm.indexOf("select") != -1) {
	    		rtnMap.put("result", (List<Map>) tClass.getClass().getMethod(actNm, Map.class).invoke(tClass, param));
	    	}else if(actNm.indexOf("save") != -1) {
	    		rtnMap.put("result", (int) tClass.getClass().getMethod(actNm, List.class).invoke(tClass, param.get("list")));
	    	}
//			rtnMap.put("result", (List<Map>) tClass.getClass().getMethod(actNm, Map.class).invoke(tClass, param));
			log.info("CommonController rtnMap >> " + rtnMap);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
    	return new ResponseEntity<>(rtnMap, HttpStatus.OK);
    }
}
