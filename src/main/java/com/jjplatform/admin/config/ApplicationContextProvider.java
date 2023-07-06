package com.jjplatform.admin.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext context ;

	/**
	* WebApplication의  컨텍스트 저장한다.
	* @param paContext
	* @throws BeansException
	**/
	@Override
	public void setApplicationContext(ApplicationContext paContext)  throws BeansException {
		ApplicationContextProvider.context = paContext ;
	}

	/**
	*  WebApplication의  컨텍스트를 리턴 한다.
	* @return  ApplicationContext
	**/
	public static ApplicationContext getContext() {
		return context;
	}

	/**
	* WebApplication의  컨텍스트 저장한다.
	* @param paContext
	**/
	public static void setContext(ApplicationContext paContext) {
		ApplicationContextProvider.context = paContext;
	}
}
