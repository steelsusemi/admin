package com.jjplatform.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jjplatform.admin.service.Svc001Service;

@RestController
public class ItmController {
	private final Logger log = LoggerFactory.getLogger(ItmController.class);

//	@Autowired
//	private Svc001Service itm001Service;
	
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//	@PostMapping("/jjp/{m1}")
//    public ResponseEntity<?> getComController(@RequestBody Map param, @PathVariable(value = "m1") String m1) throws Exception {
//    	 
////    	Class<?> itmClass = Class.forName("com.jjplatform.admin.service.impl.Svc001ServiceImpl");
////    	Constructor<?> cons = itmClass.getConstructor();
//    	List<Map> resultList = new ArrayList();
//		try {
////			Object itmInstance = cons.newInstance();
////			Method method = itmClass.getMethod("itmList", new Class[] {Map.class});
////	    	log.info("path >> " +m1 + " : "+ param + " : "+ itmClass+ " : "+ itmInstance+ " : "+ method);
////	    	resultList = (List<Map>) method.invoke(itmInstance, param);
//			resultList = itm001Service.itmList(param);
//	    	log.info("resultList >> " + resultList);
////		} catch (InvocationTargetException e) {
////		    // Answer:
////		    e.getCause().printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//    	return new ResponseEntity<>(resultList, HttpStatus.OK);
//    }
//    
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//   	@PostMapping("/itm/itmSave")
//    public ResponseEntity<?> itmSave(@RequestBody List<Map> paramList) throws Exception {
//		log.info("paramList >> " + paramList);
//	//       	Class<?> itmClass = Class.forName("com.jjplatform.admin.service.impl.Svc001ServiceImpl");
//	//       	Constructor<?> cons = itmClass.getConstructor();
//	   	List<Map> resultList = new ArrayList();
//		try {
//	//   			Object itmInstance = cons.newInstance();
//	//   			Method method = itmClass.getMethod("itmList", new Class[] {Map.class});
//	//   	    	log.info("path >> " +m1 + " : "+ param + " : "+ itmClass+ " : "+ itmInstance+ " : "+ method);
//	//   	    	resultList = (List<Map>) method.invoke(itmInstance, param);
//	   			int itmSave = itm001Service.itmSave(paramList);
//	//   		} catch (InvocationTargetException e) {
//	//   		    // Answer:
//	//   		    e.getCause().printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		
//		return new ResponseEntity<>(resultList, HttpStatus.OK);
//   }
}
