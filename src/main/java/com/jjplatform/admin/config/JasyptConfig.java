package com.jjplatform.admin.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Java Simplified Encryption 
 * @author FIC07049
 *
 */
@Configuration
public class JasyptConfig {
	private static Logger log = LoggerFactory.getLogger(JasyptConfig.class);
	
	@Value("${jasypt.encryptor.password}")
    private String encryptKey;
	
	@Value("${jasypt.encryptor.algorithm}")
    private String algorithm;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
    	log.info("encryptKey =======> "+encryptKey);
    	log.info("algorithm =======> "+algorithm);
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(encryptKey);
        config.setAlgorithm(algorithm);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
    
}
