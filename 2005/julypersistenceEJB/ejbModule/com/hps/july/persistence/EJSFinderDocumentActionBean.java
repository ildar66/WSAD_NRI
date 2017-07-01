package com.hps.july.persistence;

/**
 * EJSFinderDocumentActionBean
 */
public interface EJSFinderDocumentActionBean {
	/**
	 * findDocumentActionByOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentActionByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
