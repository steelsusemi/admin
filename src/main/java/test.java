import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class test {

	public static void main(String[] args) {
    	System.out.println("####################[ JasyptConfig ]####################");
    	
    	PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("ztxHSTBWuMmdi/Eu9yN1vzGAUEOD5JZPq2ayFr5lzwI=");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        
        String encId = encryptor.encrypt("jjplatform");
        String encPass = encryptor.encrypt("akfls5315!@");
        // mariaDB
        String encMariadbDriveClass = encryptor.encrypt("org.mariadb.jdbc.Driver");
        String encMariadbUrl = encryptor.encrypt("jdbc:mysql://127.0.0.1:3306/jjplatform?serverTimezone=UTC&characterEncoding=UTF-8");
        // mssSql
        String encMssqlDriveClass = encryptor.encrypt("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String encMssqlUrl = encryptor.encrypt("jdbc:sqlserver://127.0.0.1:1433;databaseName=jjplatform");
        System.out.println("####################[ JasyptConfig Enc ]####################");
        System.out.println("encId >> " + "ENC(" + encId + ")");
        System.out.println("encPass >> " + "ENC(" + encPass + ")");
        System.out.println("encMariadbDriveClass >> " + "ENC(" + encMariadbDriveClass + ")");
        System.out.println("encMariadbUrl >> " + "ENC(" + encMariadbUrl);
        System.out.println("encMssqlDriveClass >> " + "ENC(" + encMssqlDriveClass + ")");
        System.out.println("encMssqlUrl >> " + "ENC(" + encMssqlUrl + ")");
        
        System.out.println("####################[ JasyptConfig Dec ]####################");
        String decId = encryptor.decrypt(encId);
        String decPass = encryptor.decrypt(encPass);
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
	}

}
