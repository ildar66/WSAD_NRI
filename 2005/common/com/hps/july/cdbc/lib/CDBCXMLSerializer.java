package com.hps.july.cdbc.lib;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Сериализация результатов запроса в виде XML.
 * Creation date: (25.07.2005 12:35:47)
 * @author: Dmitry Dneprov
 */
public class CDBCXMLSerializer {
/**
 * CDBCXMLSerializer constructor comment.
 */
public CDBCXMLSerializer() {
	super();
}
/**
 * Сериализация результатов запроса в виде XML.
 * Creation date: (25.07.2005 12:37:05)
 * @return java.lang.String
 * @param rs com.hps.july.cdbc.lib.CDBCResultSet
 */
public static String serialize(CDBCResultSet rs, String recordName) {
	StringBuffer result = new StringBuffer();
	java.util.ListIterator it = rs.listIterator();
	while (it.hasNext()) {
		result.append("<" + recordName + ">");
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result.append(serializeRecord(ro));
		result.append("</" + recordName + ">");
	}
	return result.toString();
}
/**
 * Сериализация результатов запроса в виде XML.
 * Creation date: (25.07.2005 12:37:05)
 * @return java.lang.String
 * @param rs com.hps.july.cdbc.lib.CDBCResultSet
 */
public static String serializeRecord(CDBCRowObject ro) {
	StringBuffer result = new StringBuffer();
	java.util.HashMap headers  = ro.headers;
	ArrayList har = new ArrayList(headers.keySet());
	Collections.sort(har);
	java.util.Iterator hi = har.iterator();
	while (hi.hasNext()) {
		String headName = (String)hi.next();
		result.append("<" + headName + ">");
		result.append("<![CDATA[");
		String tempStr = ro.getColumn(headName).asString().trim();
		StringBuffer clearSB = new StringBuffer();
		try {
			for (int j=0; j < tempStr.length(); j++) {
				char theChar = tempStr.charAt(j);
				if (! Character.isISOControl(theChar)) {
					if (! Character.isIdentifierIgnorable(theChar)) {
						clearSB.append(theChar);
					}
				}
				if ((Character.isISOControl(theChar)) || (Character.isIdentifierIgnorable(theChar))) {
					System.out.println("### Bad Char "+theChar);
				}
			}
		} catch (Exception ex) {
			System.out.println("### serializeRecord ex.getMessage() = "+ex.getMessage());
		}
		result.append(clearSB);
		result.append("]]>");
		result.append("</" + headName + ">");
	}
	return result.toString();
}
}
