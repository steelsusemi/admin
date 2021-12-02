package com.jjplatform.admin.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jjplatform.admin.config.ApplicationContextProvider;
import com.jjplatform.admin.service.Svc001Service;
import com.jjplatform.admin.service.impl.Svc001ServiceImpl;

@RestController
public class SvcController {
	private static final Logger log = LoggerFactory.getLogger(SvcController.class);

	@Autowired
	private Svc001Service svc001Service;
	
    @SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	@PostMapping("/jjp/{m1}")
    public ResponseEntity<?> getComController(@RequestBody Map param, @PathVariable(value = "m1") String m1) throws Exception {
    	 
//    	Class<?> svcClass = Class.forName("com.jjplatform.admin.service.impl.Svc001ServiceImpl");
//    	Constructor<?> cons = svcClass.getConstructor();
    	List<Map> resultList = new ArrayList();
		try {
//			Object svcInstance = cons.newInstance();
//			Method method = svcClass.getMethod("svcList", new Class[] {Map.class});
//	    	log.info("path >> " +m1 + " : "+ param + " : "+ svcClass+ " : "+ svcInstance+ " : "+ method);
//	    	resultList = (List<Map>) method.invoke(svcInstance, param);
			resultList = svc001Service.svcList(param);
	    	log.info("resultList >> " + resultList);
//		} catch (InvocationTargetException e) {
//		    // Answer:
//		    e.getCause().printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return new ResponseEntity<>(resultList, HttpStatus.OK);
    }
}
