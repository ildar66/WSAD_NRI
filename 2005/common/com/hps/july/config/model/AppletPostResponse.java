/*
 * Created on 08.08.2006
 *
 * Response send after posting data from applet to the server 
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class AppletPostResponse implements Serializable {
	public static final int PROGRAMM_ERROR = -1;
	public static final int VALIDATION_ERROR = -2;
	public static final int SAVE_ERROR = -3;
	public static final int CALC_ERROR = -4;
	public static final int UNCALC_ERROR = -5;
	public static int DELETE_ERROR = -6;


	private int errorCode;
	private String errorMessage;
	
	public AppletPostResponse() {
		super();
	}

	/**
	 * @return
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param i
	 */
	public void setErrorCode(int i) {
		errorCode = i;
	}

	/**
	 * @param string
	 */
	public void setErrorMessage(String string) {
		errorMessage = string;
	}

}
