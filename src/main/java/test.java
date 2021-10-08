import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.http.HttpStatus;

public class test {

	public static void main(String[] args) {
    	System.out.println("####################[ JasyptConfig ]####################" + (400 == HttpStatus.BAD_REQUEST.value()) + HttpStatus.BAD_REQUEST.value());
    	
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
	}

}
