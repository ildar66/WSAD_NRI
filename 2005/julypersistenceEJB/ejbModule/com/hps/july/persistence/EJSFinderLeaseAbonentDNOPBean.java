package com.hps.july.persistence;

/**
 * EJSFinderLeaseAbonentDNOPBean
 */
public interface EJSFinderLeaseAbonentDNOPBean {
	/**
	 * findByPayPos
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPayPos(java.lang.Integer argPayPos) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPayPosLeaseBill
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPayPosLeaseBill(java.lang.Integer argPayPos, java.lang.Integer argLeaseBill) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByFlagWorkNRI
	 */
	public com.ibm.ejs.persistence.EJSFinder findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseAbonentDNOPsByAbonentbill
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseAbonentDNOPsByAbonentbill(com.hps.july.persistence.AbonentBillKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseAbonentDNOPsByAbonentpayment
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseAbonentDNOPsByAbonentpayment(com.hps.july.persistence.AbonentPaymentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
