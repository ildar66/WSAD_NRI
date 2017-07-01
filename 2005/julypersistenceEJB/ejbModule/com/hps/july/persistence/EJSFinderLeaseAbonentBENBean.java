package com.hps.july.persistence;

/**
 * EJSFinderLeaseAbonentBENBean
 */
public interface EJSFinderLeaseAbonentBENBean {
	/**
	 * findLeaseAbonentBENsByLeaseabonentban
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseAbonentBENsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByBen
	 */
	public com.ibm.ejs.persistence.EJSFinder findByBen(java.lang.Short argBen) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeasedocumentOrderByBenAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeasedocumentOrderByBenAsc(java.lang.Integer argLeasedocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
