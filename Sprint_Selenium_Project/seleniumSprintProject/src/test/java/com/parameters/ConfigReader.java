package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties prop;
	

	
	
	//Load Properties
	
	public static void initProperties() {
		try {
			FileInputStream input = new FileInputStream("src\\test\\resources\\PropertieFiles\\config.properties");
			prop = new Properties();
			prop.load(input);
		}
		catch(IOException e) {
			System.out.println("Failed to load config.properties:"+e.getMessage());
			e.printStackTrace();
		}			
	}
	
	
	//what really is called 
	public static String getProperty(String key) {
		if(prop==null) {
			initProperties();           //if not initialized then first do that 
		}
		return prop.getProperty(key);
	}
}
