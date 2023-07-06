package com.jjplatform.admin.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jjplatform.admin.intercept.LoggerInterceptor;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class WebConfigure implements WebMvcConfigurer{
	// 인터셉터가 동작 해야 될 요청 주소 mapping 목록
	private final List<String> EXCEPT_URL = Arrays.asList("/login","/css/**", "/vue/**", "/js/**", "/img/**", "/build/**", "/docs/**", "/src/**", "/vendors/**", "/error/**");  
//	private final List<String> PASS_URL = Arrays.asList("/jjpf/**");  
	 
	//인터셉터 주소 세팅
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor()).excludePathPatterns(EXCEPT_URL);
	}
	
	//web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
    //현재 localhost:80/summernoteImage/1234.jpg
    //로 접속하면 D:/summernote_image/1234.jpg 파일을 불러온다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:///D:/summernote_image/");
    }
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/css/**", "/js/**")
//	    		.addResourceLocations("/css/", "/js/")
//	            .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
//	            .resourceChain(false)
//	            .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
//	}
	
//	@Bean
//    public LocaleResolver localeResolver() {
////        // 세션을 사용한 예제
////		SessionLocaleResolver resolver = new SessionLocaleResolver();
////		resolver.setDefaultLocale(Locale.KOREAN);
//		
//        // 쿠키를 사용한 예제
//		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//        localeResolver.setCookieName("lang");
//        return localeResolver;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
}
