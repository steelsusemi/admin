package com.jjplatform.admin.util;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jjplatform.admin.vo.UserVo;

/**
 * 공통 함수 모음
 * @author FIC07049
 *
 */
@Component
public class CommonUtils {
	private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);
	
	/**
	 * 로그인 사용자 아이디 조회
	 * 
	 * @param  
	 * @return String
	 */
	public static String getUserId() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession sessInfo = request.getSession();
		log.info("aaaaaaaaaaaaaaa >> " + sessInfo.getAttribute("userInfo"));
		UserVo userVo = new UserVo();
		userVo = (UserVo) sessInfo.getAttribute("userInfo");
		log.info("1111111111111 >> " + userVo+" : "+userVo.getUserId());
		return userVo.getUserId();
	}
	
	/**
	 * Object type 변수가 비어있는지 체크
	 * 
	 * @param obj 
	 * @return Boolean : true / false
	 */
	public static Boolean isEmpty(Object obj) {
	    if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
	    else if (obj instanceof List) return obj == null || ((List<?>) obj).isEmpty();
	    else if (obj instanceof Map) return obj == null || ((Map<?, ?>) obj).isEmpty();
	    else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
	    else return obj == null;
	}
	 
	/**
	 * Object type 변수가 비어있지 않은지 체크
	 * 
	 * @param obj
	 * @return Boolean : true / false
	*/
	public static Boolean isNotEmpty(Object obj) {
	    return !isEmpty(obj);
	}
}
