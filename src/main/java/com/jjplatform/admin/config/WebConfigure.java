package com.jjplatform.admin.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jjplatform.admin.intercept.LoggerInterceptor;

@Configuration
public class WebConfigure implements WebMvcConfigurer{
	// 인터셉터가 동작 해야 될 요청 주소 mapping 목록
	private final List<String> EXCEPT_URL = Arrays.asList("/", "/css/**", "/js/**", "/img/**", "/webjars/**", "/error");  
//	private final List<String> PASS_URL = Arrays.asList("/jjpf/**");  
	 
	//인터셉터 주소 세팅
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor()).excludePathPatterns(EXCEPT_URL);
	}
}
