package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.base.BaseClass;

public class PropertiesUtils extends BaseClass
{
	 public static FileInputStream fis =null;

	public static String readProperty(String key ){
		Properties prop = new Properties();
		try 
		{
			log.info("Reading a config.properties file.");
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);

		} 
		catch (Exception e) 
		{			
			log.info("Exception occurs while reading a config.properties file.");

			e.printStackTrace();
		}
		log.info("Config.properties file read Successfully.");

		return prop.getProperty(key);
	}
	
}
