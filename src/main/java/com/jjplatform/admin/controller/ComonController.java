package com.jjplatform.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ComonController {
	private static final Logger log = LoggerFactory.getLogger(ComonController.class);

    @GetMapping("/com/{v1}")
    public String board(@PathVariable(value = "v1") String path) {
    	log.info("path >> " +path);
        return "com/" + path;
    }
}
