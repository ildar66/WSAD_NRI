package com.hps.july.platinum.sessionbean.arenda;

/**
 * Insert the type's description here.
 * Creation date: (21.01.2003 18:41:49)
 * @author: Alexander Shrago
 */
public class LogMessageTemplate {
    private int code;
    private String text;
    private String type;
    private Object[] args;
    private boolean active = true;
    private String queryStatus;
/**
 * LogMessage constructor comment.
 */
public LogMessageTemplate(int code,String type,String message) {
	super();
	this.code=code;
	this.text=message;
	this.type=type;
}
/**
 * LogMessage constructor comment.
 */
public LogMessageTemplate(int code, String type, String message, String queryStatus) {
    super();
    this.code = code;
    this.text = message;
    this.type = type;

    this.queryStatus = queryStatus;
}
/**
 * LogMessage constructor comment.
 */
public LogMessageTemplate(int code, String type, String message,String queryStatus, boolean active) {
    super();
    this.code = code;
    this.text = message;
    this.type = type;
    this.active = active;
    this.queryStatus=queryStatus;
}
/**
 * LogMessage constructor comment.
 */
public LogMessageTemplate(int code, String type, String message, boolean active) {
    super();
    this.code = code;
    this.text = message;
    this.type = type;
    this.active = active;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 14:33:41)
 * @return int
 */
public int getCode() {
	return code;
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 21:37:51)
 * @return java.lang.String
 */
public java.lang.String getQueryStatus() {
	return queryStatus;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 14:33:41)
 * @return java.lang.String
 */
public java.lang.String getText() {
	return text;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 14:33:41)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 14:44:06)
 * @return boolean
 */
public boolean isActive() {
	return active;
}
}
