/*
 * Created on 22.01.2007
 */
package com.hps.july.dictionary.formbean;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.web.util.EditForm;

/**
 * @author irogachev
 */
public abstract class CommonConfigCtrlForm extends EditForm {

	public static final String MAIN_SUBMIT_MODE = "";  

	public static String ACTIVE_SEARCH_VALUE = "Y";
	public static String NOT_ACTIVE_SEARCH_VALUE = "N";
	public static String ALL_SEARCH_VALUE = "Y_Or_N";

	public static final String BEGIN_ID_INDEX = "0";

	private boolean isUnitInt = true;

	private String isAdminRole = FALSE_STR;
	
	private String submitMode = MAIN_SUBMIT_MODE;

	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}

	/**
	 * @return
	 */
	public String getIsAdminRole() {
		return isAdminRole;
	}

	/**
	 * @param string
	 */
	public void setIsAdminRole(String string) {
		isAdminRole = string;
	}
	
	public void setupIsAdminRole(HttpServletRequest request) {
		if ((request.isUserInRole("administrator")) || 
			(request.isUserInRole("developer")) || 
			(request.isUserInRole("confResAdmin"))) {
			setIsAdminRole(TRUE_STR);
		} else {
			setIsAdminRole(FALSE_STR);
		}
	}
	
	public String getIntegerString(String inString, boolean needInteger) {
		String outString = inString;
			try {
				Double budDouble = new Double(inString);
				if (needInteger) {
					outString = new Integer(budDouble.intValue()).toString();
				} else {
					// приводим к формату 6.2
					DecimalFormat decimalFormat = new DecimalFormat("###0.00", new DecimalFormatSymbols(Locale.US));
					outString = decimalFormat.format(budDouble);
				}
			} catch (Exception ex) {
				System.out.println("# getIntegerString inString = " + inString);
				System.out.println("# getIntegerString exception = " + ex.getMessage());
				outString = "";
			}
		return outString;
	}

	/**
	 * @return
	 */
	public String getSubmitMode() {
		return submitMode;
	}

	/**
	 * @param string
	 */
	public void setSubmitMode(String string) {
		submitMode = string;
	}

	/**
	 * @return
	 */
	public boolean isUnitInt() {
		return isUnitInt;
	}

	/**
	 * @param b
	 */
	public void setUnitInt(boolean b) {
		isUnitInt = b;
	}

}
