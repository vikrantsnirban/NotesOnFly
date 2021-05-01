package net.versatile.notesonflyservice.bo.config;

import java.util.Properties;

public class Configurations {
	public static String appRoot = null;
	public static String provider = null;
	static {
		/*System.out.println("System Environment:");
		for( String key: System.getenv().keySet()){
			System.out.println(key + " = " + System.getenv(key));
		}
		
		System.out.println("System Properties:");
		Properties properties = System.getProperties();
		for (Object key: properties.keySet()){
			String propertyKey = (String) key;
			System.out.println(key + "=" + System.getProperty(propertyKey));
		}*/
		
		provider = System.getProperty("provider");
		if(provider == null){
			System.err.println("Provider Details not provided.");
			System.exit(1);
		}else{
			appRoot = System.getProperty("appRoot");
			if(provider.equals("filesystem") && appRoot == null){
				System.err.println("Appication Root not specified when Provider is FileSystem");
				System.exit(1);
			}
		}
		
		
		
	}
}
