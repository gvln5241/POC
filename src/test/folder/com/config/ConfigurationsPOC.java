package com.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigurationsPOC {

	//http://automationstepbystep.com/2017/12/30/selenium-beginner-10-how-to-use-config-properties-file/

	static Properties prop = new Properties();
	static String projectPath= System.getProperty("user.dir");

	public static void main(String[] args) {

		readPropertiesFile();
		writePropertiesFile();
		readPropertiesFile();
	}

	public static void readPropertiesFile() {

		InputStream input;

		try {
			input = new FileInputStream(projectPath+"\\src\\test\\folder\\com\\config\\config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("Browser"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writePropertiesFile() {
		OutputStream output;

		try {
			output =  new FileOutputStream(projectPath+"\\src\\test\\folder\\com\\config\\config.properties");
			prop.setProperty("Browser", "None-Changed by Write method");
			prop.store(output, "updated from java file");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
