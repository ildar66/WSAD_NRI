/*
 * Created on 18.04.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;

/**
 * @author IShaffigulin
 *
 * Базовый Класс для ТО.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Base_TO {
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private static Integer Y = new Integer(1);
	private static Integer N = new Integer(0);
	/**
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	protected static java.lang.String getStringFromDate(Date date) {
		if (date != null) {
			return format.format(new java.util.Date(date.getTime()));
		}
		return null;
	}
	/**
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	protected static Date getDateFromString(java.lang.String dateStr) {
		if (dateStr == null || dateStr.trim().length() == 0) {
			return null;
		} else {
			try {
				java.util.Date d = format.parse(dateStr);
				return new java.sql.Date(d.getTime());
			} catch (ParseException pe) {
				return null;
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:51:35)
	 */
	protected static String getStringFromBigDecimal(BigDecimal bd) {
		if (bd != null)
			return bd.toString();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:53:10)
	 */
	protected static java.math.BigDecimal getBigDecimalFromString(String bdStr) {
		if (!bdStr.trim().equals("")) {
			try {
				return new java.math.BigDecimal(bdStr);
			} catch (NumberFormatException e) {
				return null;
			}
		} else
			return null;
	}
	/**
	 * Creation date: (08.11.2005 16:23:53)
	 * @return Boolean
	 */
	protected static Boolean getBooleanFromString(String flag) {
		return "Y".equals(flag) ? Boolean.TRUE : Boolean.FALSE;
	}
	/**
	 * Creation date: (08.11.2005 16:23:53)
	 * @return String 
	 */
	protected static String getStringFromBoolean(Boolean flag) {
		return (Boolean.TRUE).equals(flag) ? "Y" : "N";
	}

	/**
	 * Creation date: (08.11.2005 16:23:53)
	 * @return Boolean
	 */
	protected static Boolean getBooleanFromInt(Integer flag) {
		return (Y.equals(flag)) ? Boolean.TRUE : Boolean.FALSE;
	}
	/**
	 * Creation date: (08.11.2005 16:23:53)
	 * @return String 
	 */
	protected static Integer getIntFromBoolean(Boolean flag) {
		return (Boolean.TRUE).equals(flag) ? Y : N;
	}
}
