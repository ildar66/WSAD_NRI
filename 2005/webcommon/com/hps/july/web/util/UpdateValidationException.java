package com.hps.july.web.util;

/**
 * Exception, кидаемый при ошибках во время обновления БД.
 * Creation date: (06.06.2002 12:35:57)
 * @author: Dmitry Dneprov
 */
public class UpdateValidationException extends ValidationException {
/**
 * UpdateValidationException constructor.
 */
public UpdateValidationException() {
	super();
}
/**
 * UpdateValidationException constructor.
 * @param s java.lang.String
 */
public UpdateValidationException(String s) {
	super(s);
}
}
