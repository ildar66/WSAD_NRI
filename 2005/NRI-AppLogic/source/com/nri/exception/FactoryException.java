package com.nri.exception;

/**
 * This Exception defines a Factory Exception (e.g. cannot CRUD an EJB)
 * Creation date: (2/20/00 10:00:30 PM)
 * @author: Administrator
 */
public class FactoryException extends WrappedException {
/**
 * FactoryException constructor comment.
 */
public FactoryException() {
	super();
}
/**
 * FactoryException constructor comment.
 * @param s java.lang.String
 */
public FactoryException(String s) {
	super(s);
}
}
