package com.hps.july.utils;

/**
 * @author dimitry
 * Created 10.04.2006
 */
public class Logger {

	public static String INFO  = " INFO";
	public static String WARN  = " WARN";
	public static String ERROR = "ERROR";
	public static String DEBUG = "DEBUG";
	
	private Class targetClass;
	
	public Logger(Class targetClass) {
		this.targetClass = targetClass;
	}

	public void log(String logStatus, Object message){
		log(logStatus, message);
	}
	
	public void log(String logStatus, Object message, Throwable e){
		String stringMessage = "";
		
		if (message instanceof Throwable){
			stringMessage = ((Throwable)message).getMessage();
		} else if (message != null)
			stringMessage = message.toString();

		System.out.println(logStatus + " - " + targetClass.getName() + ": " + stringMessage);
		if (e != null)
			e.printStackTrace(System.out);
	}
	
	public void error(Object message, Throwable e){
		log(ERROR, message, e);
	}
	
	public void error(Object message){
		error(message, null);
	}
	
	public void info(Object message, Throwable e){
		log(INFO, message, e);
	}
	
	public void info(Object message){
		info(message, null);
	}

	public void warn(Object message, Throwable e){
		log(WARN, message, e);
	}
	
	public void warn(Object message){
		warn(message, null);
	}
	
	public void debug(Object message, Throwable e){
		log(DEBUG, message, e);
	}
	
	public void debug(Object message){
		debug(message, null);
	}
	
}
