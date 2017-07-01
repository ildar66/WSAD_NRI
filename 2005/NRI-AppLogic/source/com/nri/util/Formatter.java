package com.nri.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import com.nri.system.AppService;
/**
 * This class performs simple date formatting
 */
public class Formatter {

	private static Hashtable formatters;
	private static Formatter defaultFormatter;
	private String displayFormat;
	private SimpleDateFormat formatter;

	// Static initializer to support Singleton
	private static void initialize() {
		formatters = new Hashtable();
		Formatter mdy = new Formatter("MM/dd/yyyy");
		formatters.put("MM/dd/yyyy", mdy);
		defaultFormatter = mdy;
		Formatter ymd = new Formatter("yyyy.MM.dd");
		formatters.put("yyyy.MM.dd", ymd);
	}
	/**
	 * Formatter constructor comment.
	 */
	public Formatter() {
		// return a clone of the default Formatter!
		Formatter defaultForm = getDefaultFormatter();
		displayFormat = defaultForm.getDisplayFormat();
		formatter = defaultForm.getFormatter();
	}

	public Formatter(String dateFormateStr) {
		formatter = new SimpleDateFormat(dateFormateStr);
		displayFormat = dateFormateStr;
	}

	public static Formatter getDefaultFormatter() {
		if (defaultFormatter == null) 
		initialize();
		return defaultFormatter;
	}
	
	public String toString() {
		return getDisplayFormat();
	}
	/**
	 * Convert MM/DD/YYYY string argument and reurn 
	 * as java.util.Calendar .
	 */
	public static Calendar convertToDate(String aString) {
		Calendar cal = null;
		try {
			Date aDate = getDefaultFormatter().getFormatter().parse(aString);
			cal = Calendar.getInstance();
			cal.setTime(aDate);
		} catch (Exception e) {
			AppService.handle(e);
		}
		return cal;
	}

	/**
	 * Return java.util.Calendar in MM/DD/YY String format.
	 */
	public static String dateFormat(Calendar aCal) {
		return getDefaultFormatter().getFormatter().format(aCal.getTime());
	}

	/**
	 * Generate Calendar from date String using associated SimpleDateFormat
	 */
	public Calendar createDate(String aString) {
		Calendar cal = null;
		try {
			Date aDate = formatter.parse(aString);
			cal = Calendar.getInstance();
			cal.setTime(aDate);
		} catch (Exception e) {
			AppService.handle(e);
		}
		return cal;
	}
	/**
	 * Return java.util.Calendar in corresponding format.
	 */
	public String format(Calendar aCal) {
		return formatter.format(aCal.getTime());
	}

	/**
	 * Gets the displayFormat
	 * @return Returns a String
	 */
	public String getDisplayFormat() {
		return displayFormat;
	}
	/**
	 * Sets the displayFormat
	 * @param displayFormat The displayFormat to set
	 */
	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}

	/**
	 * Gets the formatter
	 * @return Returns a SimpleDateFormat
	 */
	public SimpleDateFormat getFormatter() {
		return formatter;
	}
	/**
	 * Sets the formatter
	 * @param formatter The formatter to set
	 */
	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

    public static Formatter findFormatter(String dateString) {
    	if (formatters == null) initialize();
    	Formatter formatter = (Formatter)formatters.get(dateString);
    	if (formatter == null)
    		return defaultFormatter;
    	return formatter;
    }
    
    public static Formatter[] getFormatters() {
    	if (formatters == null) initialize();
    	Formatter[] fs = new Formatter[formatters.size()];
    	Enumeration elems = formatters.elements();
    	for (int i=0; elems.hasMoreElements(); i++) {
			fs[i] = (Formatter)elems.nextElement();    		
    	}
    	return fs;
    }
}