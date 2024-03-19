package com.jjplatform.admin.contents;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;

@Component
public class ValiableContents {
	private static Logger log = LoggerFactory.getLogger(ValiableContents.class);
	
	public static String[] MAP_LIST = {"BOA001M", "COM001M"};
}
