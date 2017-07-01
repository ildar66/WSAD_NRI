package com.hps.july.persistence;

/**
 * Root class of the stream converter heirarchy.
 *
 * Licensed Material - Property of IBM 
 * IBM(R) VisualAge(TM) for Java(TM) Version 2.0 
 * (C) Copyright IBM Corp. 1997, 1998 - All Rights Reserved. 
 * US Government Users Restricted Rights - Use, duplication or disclosure 
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *
 */
abstract class JulyStreamToObjectConverter extends com.ibm.vap.converters.VapAbstractConverter {
	private final static String copyright = "Licensed Materials -- Property of IBM\n(c) Copyright International Business Machines Corporation, 1998, 2000";
/**
 * Extracts a byte[] from an InputStream.
 */
protected byte[] bytesFromInputStream (java.io.InputStream stream) {
	byte[] rawBytes = null;
	int rawBytesLength = 0;

	try {
		int bytesRead = 0;
		java.util.Vector byteBuffers = new java.util.Vector();
		java.util.Vector byteBufferLengths = new java.util.Vector();
		while (bytesRead != -1) {
			byte[] nextRawBytes = new byte[2000];
			bytesRead = stream.read(nextRawBytes);
			if (bytesRead > 0) {
				rawBytesLength += bytesRead;
				byteBuffers.addElement(nextRawBytes);
				byteBufferLengths.addElement(new Integer(bytesRead));
			}
		}

		if (rawBytesLength > 0) {
			rawBytes = new byte[rawBytesLength];
			int rawBytesPosition = 0;
			int byteBufferCount = byteBuffers.size();
			for (int i = 0; i < byteBufferCount; i++) {
				byte[] bytes = (byte[])byteBuffers.elementAt(i);
				bytesRead = ((Integer)byteBufferLengths.elementAt(i)).intValue();
				for (int j = 0; j < bytesRead; j++)
					rawBytes[rawBytesPosition + j] = bytes[j];
				rawBytesPosition += bytesRead;
			}
		}
	}
	catch (java.io.IOException exc) {
		RuntimeException rtExc = new RuntimeException(exc.getMessage());
		rtExc.fillInStackTrace();
		throw rtExc;
	}
	
	return rawBytes;
}
/**
 * Return the data elements class name. This should return the name of the class for the data element
 * passed as a parameter to the objectFrom: message sent to the converter.
 */
public static String[] getSourceDatatype() {
	return getStringDatatypes();
}
/**
 * Extracts a String from a Clob.
 */
protected String stringFromClob (java.sql.Clob aClob) {
	try {
		return aClob.getSubString(1, (int)aClob.length());
	}
	catch (java.sql.SQLException exc) {
		RuntimeException rtExc = new RuntimeException(exc.getMessage());
		rtExc.fillInStackTrace();
		throw rtExc;
	}
}
}
