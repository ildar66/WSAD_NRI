package com.hps.july.siteinfo.locservlet;

public class ChangeSerialException
	extends Exception
{
	private String code = "500";
	private String arg = "";
/**
 * ChangeSerialException constructor comment.
 */
public ChangeSerialException() {
	super();
}
public ChangeSerialException(int errorCode) {
	super();
	this.code = String.valueOf(errorCode);
	if(this.code != null && this.code.length() != 3) {
		this.code = "500";
		this.arg = "Неверный код ошибки в сервлете: ["+errorCode+"]";
	} else {
		this.arg = "";
	}
}
public ChangeSerialException(int errorCode, String errorArg) {
	super();
	this.code = String.valueOf(errorCode);
	if(this.code != null && this.code.length() != 3) {
		this.code = "500";
		this.arg = "Неверный код ошибки в сервлете: ["+errorCode+"]";
	} else {
		this.arg = errorArg;
		if(this.arg == null) {
			this.arg = "";
		}
	}
}
/**
 * ChangeSerialException constructor comment.
 * @param s java.lang.String
 */
public ChangeSerialException(String s) {
	super(s);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getArg() {
	return arg;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCode() {
	return code;
}
}
