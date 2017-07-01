package com.hps.july.basestation.valueobject;

/**
 * Класс для представления пар строк для использования в
 * заявке на назначение радиочастот для радиорелейных
 * линий связи
 */
public class ReportStringPair  implements Comparable {
	private java.lang.String firstString = "";
	private java.lang.String secondString = "";
/**
 * ReportStringPair constructor comment.
 */
public ReportStringPair() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2004 14:53:32)
 * @param str1 java.lang.String
 * @param str2 java.lang.String
 */
public ReportStringPair(String str1, String str2) {
	firstString = str1;
	secondString = str2;	
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2004 15:11:42)
 * @return int
 * @param obj java.lang.Object
 */
public int compareTo(Object obj) throws ClassCastException {
	if(!(obj instanceof ReportStringPair))
		throw new ClassCastException();
	else {
		ReportStringPair secondPair = (ReportStringPair)obj;
		String firstObjStr = firstString + secondString;
		String secondObjStr = secondPair.getFirstString() + secondPair.getSecondString();
		return firstObjStr.compareTo(secondObjStr);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2004 14:43:24)
 * @return boolean
 * @param obj java.lang.Object
 */
public boolean equals(Object obj) {
	if(!(obj instanceof ReportStringPair))
		return false;
	else {
		ReportStringPair secondPair = (ReportStringPair)obj;
		return((firstString.equalsIgnoreCase(secondPair.getFirstString())) && 
						(secondString.equalsIgnoreCase(secondPair.getSecondString())));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2004 14:40:29)
 * @return java.lang.String
 */
public java.lang.String getFirstString() {
	return firstString;
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2004 14:40:57)
 * @return java.lang.String
 */
public java.lang.String getSecondString() {
	return secondString;
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2004 14:40:29)
 * @param newFirstString java.lang.String
 */
public void setFirstString(java.lang.String newFirstString) {
	firstString = newFirstString;
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2004 14:40:57)
 * @param newSecondString java.lang.String
 */
public void setSecondString(java.lang.String newSecondString) {
	secondString = newSecondString;
}
}
