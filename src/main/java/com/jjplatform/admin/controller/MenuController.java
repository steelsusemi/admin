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

import com.jjplatform.admin.service.Menu001Service;

@RestController
public class MenuController {
	private final Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private Menu001Service menu001Service;
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/menu/menuList")
    public ResponseEntity<?> getComController(@RequestBody Map param) throws Exception {
    	 
    	List<Map> resultList = new ArrayList();
    	log.info("111111111111111111 >> " + resultList);
		try {
			resultList = menu001Service.selectMenuList(param);
	    	log.info("resultList >> " + resultList);
//		} catch (InvocationTargetException e) {
//		    // Answer:
//		    e.getCause().printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return new ResponseEntity<>(resultList, HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
   	@PostMapping("/menu/menuSave")
    public ResponseEntity<?> svcSave(@RequestBody List<Map> paramList) throws Exception {
		log.info("paramList >> " + paramList);
	//       	Class<?> svcClass = Class.forName("com.jjplatform.admin.service.impl.Svc001ServiceImpl");
	//       	Constructor<?> cons = svcClass.getConstructor();
	   	List<Map> resultList = new ArrayList();
		try {
	//   			Object svcInstance = cons.newInstance();
	//   			Method method = svcClass.getMethod("svcList", new Class[] {Map.class});
	//   	    	log.info("path >> " +m1 + " : "+ param + " : "+ svcClass+ " : "+ svcInstance+ " : "+ method);
	//   	    	resultList = (List<Map>) method.invoke(svcInstance, param);
	   			int svcSave = menu001Service.saveMenu(paramList);
	//   		} catch (InvocationTargetException e) {
	//   		    // Answer:
	//   		    e.getCause().printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return new ResponseEntity<>(resultList, HttpStatus.OK);
   }
}
