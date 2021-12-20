package com.jjplatform.admin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.jjplatform.admin.comm.vo.CustomUserDetails;
import com.jjplatform.admin.vo.UserVo;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String root(Authentication authentication) {
    	if (authentication != null) {
    		return "main/main";
    	}
    	
        return "user/login";
    }

	@GetMapping("/main")
    public String main(HttpServletRequest request, HttpServletResponse respose, Authentication authentication, Model model) throws IOException {
    	log.info("###################[ Main Page 이동]###################");
//    	if(true) {
//    		throw new CustomException(ErrorCode.TEMPORARY_SERVER_ERROR);
//    	}
    	
    	log.info("authentication : " + authentication);
    	if (authentication != null) {
			log.info("타입정보 : " + authentication.getClass());
			
			// 세션 정보 객체 반환
			WebAuthenticationDetails web = (WebAuthenticationDetails)authentication.getDetails();
			log.info("세션ID : " + web.getSessionId());
			log.info("접속IP : " + web.getRemoteAddress());

			
			// UsernamePasswordAuthenticationToken에 넣었던 UserDetails 객체 반환
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//			log.info("ID정보 : " + userDetails.getUserVo().get(0).getUserId()); 
			log.info("ID정보 : " + userDetails.getUserVo().getUserId()); 
			
			HttpSession sessInfo = request.getSession();
			UserVo userVo = (UserVo) sessInfo.getAttribute("userInfo");
			
			if(userVo == null && request.getRequestURI().equals("/main")) {
				log.info("userDetails.getUserVo() : " + userDetails.getUserVo()); 
				sessInfo.setAttribute("userInfo", userDetails.getUserVo());
				sessInfo.setMaxInactiveInterval(300);  // 60초
				log.info("ID정보 : " + userVo); 
//				sessInfo.invalidate();
			}
			
			log.info("세션 정보 : " + sessInfo.getAttribute("userInfo")+" : "+request.getRequestURI());
		}
    	
//    	UserVo userInfo = (UserVo) request.getSession().getAttribute("userInfo");
//    	if(userInfo == null) {
//    		
//    	}
    	
        return "main/main";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
    	log.info("login : 2222222222222"); 
        return "user/login";
    } 
    
    @GetMapping("/logout")
    public String loout() throws Exception {
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();                                                                                                                                                                                                                                                                                                                                                                                                                              
//    	if (auth != null) {
//    		new SecurityContextLogoutHandler().logout(request, response, auth);
//    	}

        return "user/login";
    }

    @GetMapping("/error")
    public String accessDenied() {
        return "error/page_500";
    }
    
    @GetMapping("/board")
    public String board() {
        return "board/board";
    }
    
    @GetMapping("/menuList")
    public String menuList() {
        return "com/menuList";
    }
    
    @GetMapping("/main1")
    public String main1(){
    	return "main/main1";
    }
    
    @GetMapping("/main2")
    public String main2(){
    	return "main/main2";
    }
    
    @GetMapping("/main3")
    public String main3(){
    	return "main/main3";
    }

    @GetMapping("/cpbos/doConnVan")
    public ResponseEntity<?> doConnVan(@RequestParam Map<String, Object> param){
       ResponseEntity<String> result = null;
       String url = "https://test.mobilians.co.kr/cp/tradeFileDownload.jsp";
//       String url = "https://test.mobilians.co.kr/cp/tradeFileDownload.jsp?date=20211209&id=M9999999&dkey=9999&no=90003";
       try {
          RestTemplate restTemplate = new RestTemplate();
//          MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
          UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
          builder.queryParam("date", "20211209");
          builder.queryParam("id", "M9999999");
          builder.queryParam("dkey", "9999");
          builder.queryParam("no", "90003");
          
          HttpHeaders headers = new HttpHeaders();
          HttpEntity<?> entity = new HttpEntity<>(headers);
//          HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
           
          result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
          log.info("result => " + result);
       }catch(Exception e) {
          e.printStackTrace();
       }
       
       return result;
    }
}
