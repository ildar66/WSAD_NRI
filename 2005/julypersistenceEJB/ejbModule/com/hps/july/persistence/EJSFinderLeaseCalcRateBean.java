package com.hps.july.persistence;

/**
 * EJSFinderLeaseCalcRateBean
 */
public interface EJSFinderLeaseCalcRateBean {
	/**
	 * findBy_Hand_LeaseDocPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findBy_Hand_LeaseDocPosition(java.lang.String argByHand, java.lang.Integer argDocPosition) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseCalcRatesByDocposition
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseCalcRatesByDocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseCalcRatesByCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseCalcRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseCalcRatesByAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseCalcRatesByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
