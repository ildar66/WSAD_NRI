package com.hps.july.jdbcpersistence.lib;

/**
 * Исключительная ситуация пустого результата.
 * Creation date: (19.09.2002 15:06:13)
 * @author: Administrator
 */
public class ResultEmptyException extends Exception {
/**
 * ParameterAbsentException constructor comment.
 */
public ResultEmptyException() {
	super();
}
/**
 * ParameterAbsentException constructor comment.
 * @param userMessage java.lang.String
 */
public ResultEmptyException(String userMessage) {
	super(userMessage);
}
}
