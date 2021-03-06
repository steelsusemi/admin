package com.jjplatform.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;

@Configuration
//@MapperScan(basePackages = {"com.jjplatform.admin.dao"})
@SpringBootApplication(scanBasePackages={"com.jjplatform.admin"})
@PropertySource({ "classpath:/config/application.yml"
				, "classpath:/config/application-${spring.profiles.active}.yml"
				})
public class JJPlatformApplication {
	private static Logger log = LoggerFactory.getLogger(JJPlatformApplication.class);

    public static void main(String[] args) {
    	log.info("####################[ JJPlatformApplication Start ]####################");
//        SpringApplication.run(JJPlatformApplication.class, args);
    	// 사용자 정의를 사용한 초기 초기화 속성 암호화
        new SpringApplicationBuilder().environment(new StandardEncryptableEnvironment()).sources(JJPlatformApplication.class).run(args);
    }
}
