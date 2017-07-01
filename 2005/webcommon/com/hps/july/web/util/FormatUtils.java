package com.hps.july.web.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hps.july.web.util.StringAndBigDecimalProperty;

/**
 * @author dimitry
 * Created 25.04.2006
 */
public class FormatUtils {

	private static String DEFAULT_DATE_FORMAT = "dd.MM.yyyy";
	
	public static String toString(Integer value){
		return value != null ? value.toString() : "";
	}
	
	public static String toString(int value){
		return String.valueOf(value);
	}
	
	public static String toString(Date date){
		return toString(date, DEFAULT_DATE_FORMAT);
	}
	
	public static String toString(Date date, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat( format );
		return dateFormat.format( new java.util.Date( date.getTime() ) );
	}

	public static Integer toInteger(int value) {
		return new Integer(value);
	}

	public static int toInt(String value) {
		Integer integerValue = toInteger(value);
		return toInt(integerValue);
	}
	
	public static Integer toInteger(String value) {
		if (value == null || value.length() == 0) return null;
		try {
			return Integer.valueOf(value);
		} catch( NumberFormatException e ) {
			e.printStackTrace(System.out);
			return null;
		}

	}

	public static Date toDate(String date){
		return toDate(date, DEFAULT_DATE_FORMAT);
	}
	
	public static Date toDate(String value, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace(System.out);
			return null;
		}
	}

	public static java.sql.Date toSqlDate(String value, String format) {
		Date date = toDate(value, format);
		return date != null ? new java.sql.Date(date.getTime()) : null;
	}
	
	public static java.sql.Date toSqlDate(String value) {
		return toSqlDate(value, DEFAULT_DATE_FORMAT);
	}

	public static BigDecimal toBigDecimal(String value) {
		StringAndBigDecimalProperty prop = new StringAndBigDecimalProperty();
		prop.setString(value);
		return prop.getBigDecimal();
	}

	public static int toInt(Integer value) {
		// TODO log message 
		if (value == null) return 0;
		return value.intValue();
	}
	
}
