package com.hps.july.persistence;

/**
 * EJSFinderLeaseVPaymentBean
 */
public interface EJSFinderLeaseVPaymentBean {
	/**
	 * findLeaseVPaymentsByAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseVPaymentsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseVPaymentDsByDebetcontract
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseVPaymentDsByDebetcontract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseVPaymentCsByCreditcontract
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseVPaymentCsByCreditcontract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
