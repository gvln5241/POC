package com.demo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JExample{

	//https://www.tutorialspoint.com/log4j/log4j_sample_program.htm

	static Logger log = Logger.getLogger(Log4JExample.class.getName());

	public static void main(String[] args){

		String projectPath= System.getProperty("user.dir");
		PropertyConfigurator.configure(projectPath+"/log4j.properties");

		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");
		
		log.trace("My Trace Log");
		log.debug("My Debug Log");
		log.info("My Info Log");
		log.warn("My Warn Log");
		log.error("My error log");
		log.fatal("My fatal log");
	}
}