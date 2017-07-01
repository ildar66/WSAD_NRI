/*
 * Created on 07.09.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * A class to implement calcute/save config error
 * @author dima
 *
 */
public class ConfigError implements Serializable {
	
	public static final String BSSTANDS = "Стойки БС";
	public static final String TRX = "Трансиверы";
	public static final String ANTENNES = "Антенны";
	public static final String CABLES = "Антенны (Кабели)";
	public static final String UNKNOWN = "Документ сохранения конфигурации";
	public static final String SECTORS = "Сектора";
	
	private String errordescr;
	private String errorsection;
	private int errorline;
	
	public ConfigError() {
		super();
	}

	public ConfigError(String aerrordescr, String aerrorsection, int aerrorline) {
		super();
		errordescr = aerrordescr;
		errorsection = aerrorsection;
		errorline = aerrorline;
	}


	/**
	 * @return
	 */
	public String getErrordescr() {
		return errordescr;
	}

	/**
	 * @return
	 */
	public int getErrorline() {
		return errorline;
	}

	/**
	 * @return
	 */
	public String getErrorsection() {
		return errorsection;
	}

	/**
	 * @param string
	 */
	public void setErrordescr(String string) {
		errordescr = string;
	}

	/**
	 * @param i
	 */
	public void setErrorline(int i) {
		errorline = i;
	}

	/**
	 * @param string
	 */
	public void setErrorsection(String string) {
		errorsection = string;
	}

}
