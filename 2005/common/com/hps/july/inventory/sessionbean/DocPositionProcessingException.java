package com.hps.july.inventory.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (30.05.2002 20:45:37)
 * @author: Oleg Gashnikov
 */
public class DocPositionProcessingException extends Exception {
	private ProcessingPositionError error;
/**
 * DocPositionProcessingException constructor comment.
 */
public DocPositionProcessingException() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 20:47:39)
 * @param argError com.hps.july.inventory.sessionbean.ProcessingPositionError
 */
public DocPositionProcessingException(ProcessingPositionError argError) {
	error = argError;
}
/**
 * DocPositionProcessingException constructor comment.
 * @param s java.lang.String
 */
public DocPositionProcessingException(String s) {
	super(s);
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 20:46:30)
 * @return com.hps.july.inventory.sessionbean.ProcessingPositionError
 */
public ProcessingPositionError getError() {
	return error;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 20:46:30)
 * @param newError com.hps.july.inventory.sessionbean.ProcessingPositionError
 */
public void setError(ProcessingPositionError newError) {
	error = newError;
}
}
