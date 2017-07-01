package com.hps.july.persistence;

import com.ibm.vap.converters.streams.*;
/**
 * This type was created in VisualAge.
 */
public class JulyAsciiStreamToStringConverter extends JulyAsciiStreamToObjectConverter {
	static JulyAsciiStreamToStringConverter singleton = null;
	private final static String copyright = "Licensed Materials -- Property of IBM\n(c) Copyright International Business Machines Corporation, 1999, 2000";
/**
 * Return the target class name. This should return the name of the class for the instance instanciated
 * as a result of the objectFrom: message sent to the converter.
 */
public static String getTargetClassName() {
	return "java.lang.String";
}
/**
 * Set the singleton variable to null.
 * This is required by each subclass.
 */
public static void reset() {
	singleton = null;
	return;
}

/**
 * This method was created by a SmartGuide.
 * @return com.ibm.vap.converters.streams.VapAsciiStreamToStringConverter
 */
public static JulyAsciiStreamToStringConverter singleton ( ) {
	if (singleton == null) 
		singleton = new JulyAsciiStreamToStringConverter();
	return singleton;
}
}
