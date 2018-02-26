package com.propertyloader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	public static final Properties prop = new Properties();
	
	static {
	try(InputStream input = new FileInputStream("src/main/resources/config.properties")) {
		
					prop.load(input);
					
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
