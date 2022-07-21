import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.Token;

public class test {

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
//    	System.out.println("####################[ JasyptConfig ]####################" + (400 == HttpStatus.BAD_REQUEST.value()) + HttpStatus.BAD_REQUEST.value());
//    	
//    	PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword("AUPtH1EvaZFrQ4O/Ntz4uFSg6c12GsbKMwKPrK+PW/iH0ibCsy4M/sZYpev9EAG83dz0syVyKS1g27GitqkGjQ==");
//        config.setAlgorithm("PBEWithHmacSHA512AndAES_256");
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
//        config.setProviderName("SunJCE");
//        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
//        config.setStringOutputType("AES256");
//        encryptor.setConfig(config);
//        
//        String encId = encryptor.encrypt("jjplatform");
//        String encPass = encryptor.encrypt("akfls5315!@");
//        // mariaDB
//        String encMariadbDriveClass = encryptor.encrypt("org.mariadb.jdbc.Driver");
//        String encMariadbUrl = encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/jjplatform?serverTimezone=UTC&characterEncoding=UTF-8");
//        String encPassword = encryptor.encrypt("J.J.PlatformGksekfdp1djr");
//        // mssSql
//        String encMssqlDriveClass = encryptor.encrypt("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String encMssqlUrl = encryptor.encrypt("jdbc:sqlserver://127.0.0.1:1433;databaseName=jjplatform");
//        System.out.println("####################[ JasyptConfig Enc ]####################");
//        System.out.println("encId >> " + "ENC(" + encId + ")");
//        System.out.println("encPass >> " + "ENC(" + encPass + ")");
//        System.out.println("encMariadbDriveClass >> " + "ENC(" + encMariadbDriveClass + ")");
//        System.out.println("encMariadbUrl >> " + "ENC(" + encMariadbUrl + ")");
//        System.out.println("encMssqlDriveClass >> " + "ENC(" + encMssqlDriveClass + ")");
//        System.out.println("encMssqlUrl >> " + "ENC(" + encMssqlUrl + ")");
//        System.out.println("password >> " + "ENC(" + encPassword + ")");
//        
//        System.out.println("####################[ JasyptConfig Dec ]####################");
//        String decId = encryptor.decrypt(encId);
//        String decPass = encryptor.decrypt(encPass);
//        String decPassword = encryptor.decrypt(encPassword);
//        // mariaDB
//        String decMariadbDriveClass = encryptor.decrypt(encMariadbDriveClass);
//        String decMariadbUrl = encryptor.decrypt(encMariadbUrl);
//        // mssSql
//        String decMssqlDriveClass = encryptor.decrypt(encMssqlDriveClass);
//        String decMssqlUrl = encryptor.decrypt(encMssqlUrl);
//        System.out.println("decId >> " + decId);
//        System.out.println("decPass >> " + decPass);
//        System.out.println("decMariadbDriveClass >> " + decMariadbDriveClass);
//        System.out.println("decMariadbUrl >> " + decMariadbUrl);
//        System.out.println("decMssqlDriveClass >> " + decMssqlDriveClass);
//        System.out.println("decMssqlUrl >> " + decMssqlUrl);
//        System.out.println("decPassword >> " + decPassword);
//		Class clazz;
//		try {
//			clazz = Class.forName("com.jjplatform.admin.service.CommonService");
//			Method[] methods = clazz.getDeclaredMethods();
//		    List<String> actualMethods = getMethodNames(methods);
//
////		    assertTrue(actualMethods.containsAll(Arrays.asList("getName","setName", "getSound")));
////			System.out.println("Constructor: " + constructor.getName());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		String TestClass = "com.jjplatform.admin.service.CommonService"; // 원래는 패키지 경로까지 적어야 하나 같은 default 경로라 생략
//		Map rtnMap = new HashMap<>();
//		try {
//            // 이것만 선언할 경우 static만 호출 => 여기서 System.out.println("난 static블럭에 있는 함수"); 호출
//			Class<?> finedClass = Class.forName(TestClass); 
//			System.out.println("Class.forName : " + finedClass.getName());
//			Object classInstance = finedClass.newInstance(); // 클래스의 받아온 정보를 기반으로 객체를 생성 
//			System.out.println("Class Instance : " + classInstance);
//			Method m = finedClass.getMethod("leftMenuList", Map.class); // 메소드 불러오기 
//			System.out.println("Class Method : " + m.getName() + "를 찾았습니다.");
//			m.invoke(classInstance, rtnMap);
//			System.out.println("Class Method : " + m.getName() + "를 호출하였습니다.");
////			m.invoke(newObj, rtnMap); // 메소드 호출 A 3 출력
//			
//			// testClass.getMethod("A").invoke(newObj);  A가 생성되었습니다. public일 때
//
////            m = testClass.getDeclaredMethod("A"); 
////			m.setAccessible(true); // private를 접근하기 위해서는 getDeclaredMethod 뒤에 해줘야 한다.
////			m.invoke(newObj);   //  A가 생성되었습니다.
//
//		} catch (Exception e) {
//		}

//		System.out.println("USER0012M".substring(0, "USER0012M".length() - 5));
		
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
//        komoran.setUserDic("C:\\PJT\\workerspace\\user_data\\dic.user");
        List<Token> tokens = komoran.analyze("청하는아이오아이출신입니다").getTokenList();
        for(Token token : tokens)
            System.out.println(token);
	}
	
	private static List<String> getMethodNames(Method[] methods) {
	    List<String> methodNames = new ArrayList<>();
	    for (Method method : methods)
	      methodNames.add(method.getName());
	    return methodNames;
	}

}

class ADSA {
	private void A() {
		System.out.println("A가 생성되었습니다.");
	}

	public void show(boolean showOK, Integer a) {
		if (showOK)
			System.out.println("A " + a + " 출력");
	}

	static {
		System.out.println("난 static블럭에 있는 함수");
	}
}	
