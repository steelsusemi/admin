package com.jjplatform.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.config.ApplicationContextProvider;
import com.jjplatform.admin.service.CommonService;
import com.jjplatform.admin.vo.UserVo;


@Controller
public class CommonController {
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;
	
    @GetMapping("/move/{v1}")
    public String commonMenuMove(HttpServletRequest request, Authentication authentication, @PathVariable(value = "v1") String path) {
    	log.info("commonMenuMove => " + path);
    	String v1 = "";
    	path = path.toUpperCase();
    	
    	if(path.contains("MNU")) {
    		v1 = "sys";
    	}else if(path.contains("USR")) {
    		v1 = "user";
    	}else if(path.contains("MAIN")) {
    		this.setSession(request, authentication);
    		v1 = "main";
    	}else if(path.contains("ADM")) {
    		v1 = "admg";
    	}else {
    		v1 = path.substring(0, path.length() - 4);
    	}
    	log.info("path >> " +path + " : "+ v1.toLowerCase());
    	
    	return v1.toLowerCase() + "/" + path.toLowerCase();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked"})
	@PostMapping("/comm/{actNm}")
    public ResponseEntity<?> commonList(@RequestBody Map param, @PathVariable(value = "actNm") String actNm) {
    	String menuId = (String) param.get("menuId");
    	log.info("menuId => " + menuId + " : " + actNm);
    	
    	String serviceNm = "";
    	if("leftMenu".equals(menuId)) {
    		serviceNm = "commonService";
//    	}else if("MNU001M".equals(menuId)) {
//    		serviceNm = "mnu001Service";
//    	}else if("SVC001M".equals(menuId)) {
//    		serviceNm = "svc001Service";
//    	}else if("ADM001M".equals(menuId)) {
//    		serviceNm = "adm001Service";
    	}else {
    		serviceNm = commonService.selectServiceNm(param);
    	}

    	Map rtnMap = new HashMap();
    	log.info("actNm => " + actNm.indexOf("select")+ " : " + actNm+ " : " + serviceNm);
		try {
			Object tClass = ApplicationContextProvider.getContext().getBean(serviceNm);
			if(actNm.indexOf("select") != -1) {
	    		rtnMap.put("result", (List<Map>) tClass.getClass().getMethod(actNm, Map.class).invoke(tClass, param));
	    	}else if(actNm.indexOf("save") != -1) {
	    		rtnMap.put("result", (int) tClass.getClass().getMethod(actNm, List.class).invoke(tClass, param.get("list")));
	    	}
//			rtnMap.put("result", (List<Map>) tClass.getClass().getMethod(actNm, Map.class).invoke(tClass, param));
			log.info("CommonController rtnMap >> " + rtnMap);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
    	return new ResponseEntity<>(rtnMap, HttpStatus.OK);
    }
    
    private void setSession(HttpServletRequest request, Authentication authentication) {
    	log.info("###################[ Main Page 이동]###################");
//	if(true) {
//		throw new CustomException(ErrorCode.TEMPORARY_SERVER_ERROR);
//	}
	
		log.info("authentication : " + authentication);
		if (authentication != null) {
			log.info("타입정보 : " + authentication.getClass());
			
			// 세션 정보 객체 반환
			WebAuthenticationDetails web = (WebAuthenticationDetails)authentication.getDetails();
			log.info("세션ID : " + web.getSessionId());
			log.info("접속IP : " + web.getRemoteAddress());
	
			
			// UsernamePasswordAuthenticationToken에 넣었던 UserDetails 객체 반환
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
	//		log.info("ID정보 : " + userDetails.getUserVo().get(0).getUserId()); 
			log.info("ID정보 : " + userDetails.getUserVo().getUserId()); 
			
			HttpSession sessInfo = request.getSession();
			log.info("세션정보 : " + sessInfo); 
			UserVo userVo = (UserVo) sessInfo.getAttribute("userInfo");
			
			if(userVo == null && request.getRequestURI().equals("/main")) {
				log.info("userDetails.getUserVo() : " + userDetails.getUserVo()); 
				sessInfo.setAttribute("userInfo", userDetails.getUserVo());
				sessInfo.setMaxInactiveInterval(300);  // 5분
				log.info("ID정보 : " + userVo); 
	//			sessInfo.invalidate();
			}
			
			log.info("세션 정보 : " + sessInfo.getAttribute("userInfo")+" : "+request.getRequestURI());
		}
    	
    }
}
