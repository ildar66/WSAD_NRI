package com.hps.july.persistence;

/**
 * EJSFinderLeaseDNOPBean
 */
public interface EJSFinderLeaseDNOPBean {
	/**
	 * findByLeaseChargeSource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseChargeSource(java.lang.Integer argLeaseCharge, java.lang.String argSource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseDNOPByLeaseCharge
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseDNOPByLeaseCharge(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByActAndHand
	 */
	public com.ibm.ejs.persistence.EJSFinder findByActAndHand(java.lang.Integer argAct, java.lang.String argHand) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByActAndSource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByActAndSource(java.lang.Integer argAct, java.lang.String argSource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseDNOPPayByLeasePayment
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseDNOPPayByLeasePayment(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeasePaymentSource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeasePaymentSource(java.lang.Integer argLeasePayment, java.lang.String argSource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseDNOPsByAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseDNOPsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseChargeOrderByLeasePayment
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseChargeOrderByLeasePayment(java.lang.Integer leaseCharge) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
