package com.jjplatform.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jjplatform.admin.comm.service.CommonService;
import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.config.ApplicationContextProvider;
import com.jjplatform.admin.contents.ValiableContents;
import com.jjplatform.admin.menu.service.Mnu001Service;
import com.jjplatform.admin.vo.UserVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class CommonController {
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private Mnu001Service mnu001Service;
	
    @GetMapping("/move/{v1}")
    public String commonMenuMove(HttpServletRequest request, HttpServletResponse respose, Authentication authentication, @PathVariable(value = "v1") String path) throws IOException {
    	log.info("###################[ 페이지이동 ]###################");
    	log.info("commonMenuMove => " + path);
//    	String v1 = "";
//    	path = path.toUpperCase();
//    	if(path.contains("MNU")) {
//    		v1 = "sys";
//    	}else if(path.contains("USR")) {
//    		v1 = "user";
//    	}else if(path.contains("MAIN")) {
//    		this.setSession(request, authentication);
//    		v1 = "main";
//    	}else if(path.contains("ADM")) {
//    		v1 = "admg";
//    	}else if(path.contains("FAM")) {
//    		v1 = "farm";
//    	}else {
//    		v1 = path.substring(0, path.length() - 4);
//    	}
    	
//    	log.info("path >> " +path + " : "+ v1.toLowerCase());
//    	return v1.toLowerCase() + "/" + path.toLowerCase();
    	
    	if(path.contains("MAIN")) this.setSession(request, authentication);
    	String menuId = mnu001Service.selectMenuId(path).toLowerCase();
    	log.info("menuId >> " +menuId + " : "+ path.toLowerCase());
    	return menuId + "/" + path.toLowerCase();
    }
    
    /**
     * 공통 Api 호출 처리
     * @param param
     * @param actNm
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked"})
	@PostMapping("/comm/{actNm}")
    public ResponseEntity<?> commonList(@RequestBody Map param, @PathVariable(value = "actNm") String actNm) {
    	log.info("###################[ 공통 Api 호출 처리 ]###################");
    	String menuId = (String) param.get("menuId");
    	log.info("menuId => " + menuId + " : " + actNm);
    	
    	String serviceNm = "";
    	if("leftMenu".equals(menuId)) serviceNm = "commonService";
    	else serviceNm = commonService.selectServiceNm(param);

    	Map rtnMap = new HashMap();
    	log.info("actNm => " + actNm.indexOf("select")+ " : " + actNm+ " : " + serviceNm);
		try {
			Object tClass = ApplicationContextProvider.getContext().getBean(serviceNm);
			if(actNm.indexOf("select") != -1) {
	    		rtnMap.put("result", (List<Map>) tClass.getClass().getMethod(actNm, Map.class).invoke(tClass, param));
	    	}else if(actNm.indexOf("save") != -1) {
	    		boolean exceptCheck = Arrays.asList(ValiableContents.MAP_LIST).contains(menuId);
	    		log.info("exceptCheck > "+exceptCheck);
	    		rtnMap.put("result", (int) tClass.getClass().getMethod(actNm, (exceptCheck) ? Map.class : List.class).invoke(tClass, (exceptCheck) ? param : param.get("list")));
	    	}
//			rtnMap.put("result", (List<Map>) tClass.getClass().getMethod(actNm, Map.class).invoke(tClass, param));
			log.info("CommonController rtnMap >> " + rtnMap);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
    	return new ResponseEntity<>(rtnMap, HttpStatus.OK);
    }
    
    /**
     * 공통 파일 업로드 처리
     * @param param
     * @param actFile
     * @return
     */
	@PostMapping("/file/uploadFile")
    public ResponseEntity<?> fileProcess(@RequestParam("file") MultipartFile fileParam) {
//    	String menuId = (String) param.get("menuId");
		log.info("###################[ 파일업로드 시작 ]###################");
    	log.info("fileParam => " + fileParam);
    	
    	JsonObject jsonObject = new JsonObject();
		
		String fileRoot = "D:\\summernote_image\\";				//저장될 외부 파일 경로
		String originalFileName = fileParam.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
				
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		File targetFile = new File(fileRoot + savedFileName);	
		
		log.info("###################[ 파일정보 시작 ]###################");
		log.info("fileName => " + fileParam.getOriginalFilename());
		log.info("fileSize => " + fileParam.getSize());
		log.info("savedFileName => " + savedFileName);
		log.info("getName => " + fileParam.getName());
		log.info("fileRoot => " + fileRoot);
		log.info("###################[ 파일정보 종료 ]###################");
		
		try {
			InputStream fileStream = fileParam.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/image/"+savedFileName);
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		Gson gson = new Gson();
		log.info("jsonObject => " +gson.fromJson(jsonObject, Map.class));
		log.info("###################[ 파일업로드 종료 ]###################");
    	return new ResponseEntity<>(gson.fromJson(jsonObject, Map.class), HttpStatus.OK);
    }
    
    @SuppressWarnings("unused")
	private void setSession(HttpServletRequest request, Authentication authentication) {
    	log.info("###################[ Main Page 이동 ]###################");
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
