package com.jjplatform.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ComonController {
//	private static final Logger log = LoggerFactory.getLogger(ComonController.class);
//
//    @GetMapping("/{v1}")
//    public String board(@PathVariable(value = "v1") String path) {
//    	String v1 = "";
//    	path = path.toUpperCase();
//    	
//    	if(path.contains("MNU")) {
//    		v1 = "sys";
//    	}else if(path.contains("USR")) {
//    		v1 = "user";
//    	}else {
//    		v1 = path.substring(0, path.length() - 4);
//    	}
//    	log.info("path >> " +path + " : "+ v1.toLowerCase());
//    	
//    	return v1.toLowerCase() + "/" + path;
//    }
}
