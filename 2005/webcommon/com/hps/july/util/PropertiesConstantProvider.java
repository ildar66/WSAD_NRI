/*
 * Created on 26.04.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.util;

import java.util.Properties;
import java.io.InputStream;

/**
 * @author AAErmolov
 * 
 * based on:
 *
 *  $Id: PropertiesConstantProvider.java,v 1.2 2007/05/03 13:17:59 ddneprov Exp $
 *  Copyright (c) 2003 - 2006 ОАО Вымпелком    
 */
public class PropertiesConstantProvider {
	private String fileName;
	private Properties properties;
	public PropertiesConstantProvider() {
		setFileName("nri-constants.properties");
		afterPropertiesSet();
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void afterPropertiesSet(){
		properties = new Properties();
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			InputStream is = null;
			if(cl != null) 
				is = cl.getResourceAsStream(fileName);
			if(is == null) {
				cl = this.getClass().getClassLoader();
				is = cl.getResourceAsStream(fileName);
			}
			properties.load(is);
			System.out.println("[PropertiesConstantProvider] : properties loaded");
		} catch(Exception e) {
			System.out.println("Cannot find file '"+fileName+"'");
		}
	}
	public String getValue(String value) {
		if(value != null) return properties.getProperty(value);
		return null;
	}
}





