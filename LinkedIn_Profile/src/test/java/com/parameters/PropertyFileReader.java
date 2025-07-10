package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	private Properties properties;
	 
    public PropertyFileReader(String filePath) {
    	
    	System.out.println("Called 1");
    	
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            System.err.println("Properties file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
        }
    }
 
    public String getProperty(String key) {
    	System.out.println("Called");
        return properties.getProperty(key);
    }
}
