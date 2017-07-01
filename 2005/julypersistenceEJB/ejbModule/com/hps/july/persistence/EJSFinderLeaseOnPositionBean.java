package com.hps.july.persistence;

/**
 * EJSFinderLeaseOnPositionBean
 */
public interface EJSFinderLeaseOnPositionBean {
	/**
	 * findLeaseOnPositionByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseOnPositionByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseonpositionsByLeaseArendaAgreementNew
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseonpositionsByLeaseArendaAgreementNew(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
