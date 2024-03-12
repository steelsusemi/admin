import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.Token;
import kr.co.shineware.nlp.komoran.modeler.builder.ModelBuilder;

/**
 * @author FIC07049
 *
 */
/**
 * @author FIC07049
 *
 */
/**
 * @author FIC07049
 *
 */
/**
 * @author FIC07049
 *
 */
public class test {

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
//    	System.out.println("####################[ JasyptConfig ]####################" + (400 == HttpStatus.BAD_REQUEST.value()) + HttpStatus.BAD_REQUEST.value());
    	
    	PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("AUPtH1EvaZFrQ4O/Ntz4uFSg6c12GsbKMwKPrK+PW/iH0ibCsy4M/sZYpev9EAG83dz0syVyKS1g27GitqkGjQ==");
        config.setAlgorithm("PBEWithHmacSHA512AndAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("AES256");
        encryptor.setConfig(config);
        
        String encId = encryptor.encrypt("jjplatform");
        String encPass = encryptor.encrypt("akfls5315!@");
        // mariaDB
        String encMariadbDriveClass = encryptor.encrypt("org.mariadb.jdbc.Driver");
        String encMariadbUrl = encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/jjplatform?serverTimezone=UTC&characterEncoding=UTF-8");
        String encPassword = encryptor.encrypt("J.J.PlatformGksekfdp1djr");
        // mssSql
        String encMssqlDriveClass = encryptor.encrypt("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String encMssqlUrl = encryptor.encrypt("jdbc:sqlserver://127.0.0.1:1433;databaseName=jjplatform");
        System.out.println("####################[ JasyptConfig Enc ]####################");
        System.out.println("encId >> " + "ENC(" + encId + ")");
        System.out.println("encPass >> " + "ENC(" + encPass + ")");
        System.out.println("encMariadbDriveClass >> " + "ENC(" + encMariadbDriveClass + ")");
        System.out.println("encMariadbUrl >> " + "ENC(" + encMariadbUrl + ")");
        System.out.println("encMssqlDriveClass >> " + "ENC(" + encMssqlDriveClass + ")");
        System.out.println("encMssqlUrl >> " + "ENC(" + encMssqlUrl + ")");
        System.out.println("password >> " + "ENC(" + encPassword + ")");
        
        System.out.println("####################[ JasyptConfig Dec ]####################");
        String decId = encryptor.decrypt(encId);
        String decPass = encryptor.decrypt(encPass);
        String decPassword = encryptor.decrypt(encPassword);
        // mariaDB
        String decMariadbDriveClass = encryptor.decrypt(encMariadbDriveClass);
        String decMariadbUrl = encryptor.decrypt(encMariadbUrl);
        // mssSql
        String decMssqlDriveClass = encryptor.decrypt(encMssqlDriveClass);
        String decMssqlUrl = encryptor.decrypt(encMssqlUrl);
        System.out.println("decId >> " + decId);
        System.out.println("decPass >> " + decPass);
        System.out.println("decMariadbDriveClass >> " + decMariadbDriveClass);
        System.out.println("decMariadbUrl >> " + decMariadbUrl);
        System.out.println("decMssqlDriveClass >> " + decMssqlDriveClass);
        System.out.println("decMssqlUrl >> " + decMssqlUrl);
        System.out.println("decPassword >> " + decPassword);
		Class clazz;
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
		
//		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
////        komoran.setUserDic("C:\\PJT\\workerspace\\user_data\\dic.user");
//        komoran.setFWDic("C:\\PJT\\workerspace\\user_data\\wiki.titles");
//        List<Token> tokens = komoran.analyze("감기는 자주 걸리는 병이다 바람과 함께 사라지다를 봤어").getTokenList();
//        for(Token token : tokens)
//            System.out.println(token);
        
//        modelSave();
//        modelLoad();
//		System.out.println("USER0012M".substring(0, "USER0012M".length() - 5));
		List<String> list = List.of("one", "two", "three");
		Set<String> set = Set.of("one", "two", "three");
		Map<String, String> map = Map.of("foo", "one", "bar", "two");
		System.out.println("1 > "+list);
		System.out.println("2 > "+set);
		System.out.println("3 > "+map);
		
		List<Integer> listA = Arrays.asList(1, 2, null);
		System.out.println("4 > "+listA);
		listA.set(1, 10); // OK
		System.out.println("5 > "+listA);
		
		String[] array = {"2","1"};
		List<String> list1 = new ArrayList<>(List.of(array));
		Set<String> set1 = new HashSet<>(List.of(array));
		System.out.println("6 > "+list1+" : "+set1);
	}
	
//	private static List<String> getMethodNames(Method[] methods) {
//	    List<String> methodNames = new ArrayList<>();
//	    for (Method method : methods)
//	      methodNames.add(method.getName());
//	    return methodNames;
//	}
	
	private static void modelLoad() {
		ModelBuilder builder = new ModelBuilder();
		builder.load("models");
	}

	private static void modelSave() {
	    ModelBuilder builder = new ModelBuilder();
	    //external dictionary for out of vocabulary
//	    builder.setExternalDic("user_data"+ File.separator+"wiki.titles");
	    builder.setExternalDic("C:\\PJT\\workerspace\\user_data\\wiki.titles");
	    //training corpus path must include dictionary, grammar and irregular dictionary
	    builder.buildPath("corpus_build");
	    //path to save models
	    builder.save("models");
	}

}

//class ADSA {
//	private void A() {
//		System.out.println("A가 생성되었습니다.");
//	}
//
//	public void show(boolean showOK, Integer a) {
//		if (showOK)
//			System.out.println("A " + a + " 출력");
//	}
//
//	static {
//		System.out.println("난 static블럭에 있는 함수");
//	}
//}	
