package com.hps.july.inventory.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (29.05.2002 18:07:16)
 * @author: Oleg Gashnikov
 */
public class DocumentProcessingException extends Exception implements java.io.Serializable {
	private int errorCode;
	private java.lang.String errorMessage;
	private java.util.ArrayList positionErrors;
	private java.util.Date curDate;
	private java.lang.Integer currency;
	private java.lang.Integer rateType;
	private int curErrorCode;
	private int document;
	private java.lang.Integer otherDocument;
/**
 * DocumentProcessingException constructor comment.
 */
public DocumentProcessingException() {
	super();
	positionErrors = new java.util.ArrayList();
	document = 0;
	otherDocument = null;
}
/**
 * DocumentProcessingException constructor comment.
 */
public DocumentProcessingException( int code, String s) {
	super();
	errorCode = code;
	errorMessage = s;
}
/**
 * DocumentProcessingException constructor comment.
 * @param s java.lang.String
 */
public DocumentProcessingException(String s) {
	super(s);
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 13:39:03)
 * @param error com.hps.july.inventory.sessionbean.ProcessingPositionError
 */
public void addError(ProcessingPositionError error) {
	positionErrors.add( error );
	}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:27:22)
 * @return java.util.Date
 */
public java.util.Date getCurDate() {
	return curDate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:29:49)
 * @return int
 */
public int getCurErrorCode() {
	return curErrorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:27:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 17:28:22)
 * @return int
 */
public int getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:07:44)
 * @return int
 */
public int getErrorCode() {
	return errorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:17:54)
 * @return java.lang.String
 */
public java.lang.String getErrorMessage() {
	return errorMessage;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 11:16:27)
 * @return java.lang.Integer
 */
public java.lang.Integer getOtherDocument() {
	return otherDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 13:37:25)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getPositionErrors() {
	return positionErrors;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:27:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getRateType() {
	return rateType;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:01:59)
 */
public void print() {
	java.io.PrintWriter out = new java.io.PrintWriter( System.out, true );
	out.println("TESTMSG>>======================================");
	out.println("TESTMSG>>Documetn processing exception printout");
	out.println("TESTMSG>>Error code \t\t="+errorCode);
	out.println("TESTMSG>>Error message \t\t="+errorMessage);
	out.println("TESTMSG>>CurrencyCode \t\t="+currency);
	out.println("TESTMSG>>Rate Date \t\t="+curDate);
	out.println("TESTMSG>>Rate Type \t\t="+rateType);
	
	if( positionErrors != null ) {
		for( int i = 0; i<positionErrors.size(); i++) {
			out.println("TESTMSG>>--------------------------------------");
			((ProcessingPositionError)positionErrors.get(i)).print( out );
		}
	}
	out.println("TESTMSG>>======================================");
	}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:27:22)
 * @param newCurDate java.util.Date
 */
public void setCurDate(java.util.Date newCurDate) {
	curDate = newCurDate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:29:49)
 * @param newCurErrorCode int
 */
public void setCurErrorCode(int newCurErrorCode) {
	curErrorCode = newCurErrorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:27:36)
 * @param newCurrency java.lang.Integer
 */
public void setCurrency(java.lang.Integer newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 17:28:22)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:07:44)
 * @param newErrorCode int
 */
public void setErrorCode(int newErrorCode) {
	errorCode = newErrorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:17:54)
 * @param newErrorMessage java.lang.String
 */
public void setErrorMessage(java.lang.String newErrorMessage) {
	errorMessage = newErrorMessage;
}
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 11:16:27)
 * @param newOtherDocument java.lang.Integer
 */
public void setOtherDocument(java.lang.Integer newOtherDocument) {
	otherDocument = newOtherDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 13:37:25)
 * @param newPositionErrors java.util.ArrayList
 */
public void setPositionErrors(java.util.ArrayList newPositionErrors) {
	positionErrors = newPositionErrors;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2002 20:27:49)
 * @param newRateType java.lang.Integer
 */
public void setRateType(java.lang.Integer newRateType) {
	rateType = newRateType;
}
}
