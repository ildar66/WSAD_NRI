package com.hps.july.persistence;

import com.ibm.vap.converters.streams.*;
import java.io.*;

/**
 * Ascii stream converters assume the the input to objectFrom(...) is
 * either a String, an InputStream, or a Clob.
 * All ascii stream converters return a String from dataFrom().
 */
public abstract class JulyAsciiStreamToObjectConverter extends JulyStreamToObjectConverter {
	private final static String copyright = "Licensed Materials -- Property of IBM\n(c) Copyright International Business Machines Corporation, 1999, 2000";
/**
 * All ascii stream converters return a String from dataFrom().
 */
public Object dataFrom (Object anObject) {
	try {
		if (anObject == null) return null;
		return ((String)anObject).getBytes("windows-1251" );
	} catch( UnsupportedEncodingException e ) {
		e.printStackTrace();
		return null;
	}
}
/**
 * For ascii stream converters, the default is to return a String.
 * Ascii stream converters assume the the input to objectFrom(...) is
 * either a String, an InputStream or a Clob.
 */
public Object objectFrom (Object aField) {
	if (aField == null) return null;
	if (aField instanceof java.io.InputStream)
		return stringFromInputStream((java.io.InputStream)aField);
	else {
		if (aField instanceof java.sql.Clob)
			return stringFromClob((java.sql.Clob)aField);
		else if( aField.getClass().isArray() )
			try {
				return new String( ((byte[])aField), "windows-1251" );
			} catch( UnsupportedEncodingException e ) {
				e.printStackTrace();
				return null;
			}
		else
			return aField;
	}
}
/**
 * Extracts a String from an InputStream.
 */
protected Object stringFromInputStream (java.io.InputStream stream) {
	Object o = bytesFromInputStream(stream);
	if( o == null )
		return "";
	else
		try {
			return new String( (byte[])o, "windows-1251" );
		} catch( UnsupportedEncodingException e ) {
			e.printStackTrace();
			return null;
		}
}
}
