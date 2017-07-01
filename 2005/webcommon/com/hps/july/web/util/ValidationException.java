package com.hps.july.web.util;

/**
 * Exception, кидаемый при проверке допустимости значений полей.
 * Creation date: (22.02.2002 17:27:34)
 * @author: Dmitry Dneprov
 */
public class ValidationException extends Exception {
/**
 * ValidationException constructor.
 */
public ValidationException() {
	super();
}
/**
 * ValidationException constructor.
 * @param s java.lang.String
 */
public ValidationException(String s) {
	super(s);
}
}
