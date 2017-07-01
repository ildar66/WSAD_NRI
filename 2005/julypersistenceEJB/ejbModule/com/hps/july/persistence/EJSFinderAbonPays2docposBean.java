package com.hps.july.persistence;

/**
 * EJSFinderAbonPays2docposBean
 */
public interface EJSFinderAbonPays2docposBean {
	/**
	 * findAbonPays2docposByLeasedocposition
	 */
	public com.hps.july.persistence.AbonPays2docpos findAbonPays2docposByLeasedocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAbonPays2docposesByPaypos
	 */
	public com.ibm.ejs.persistence.EJSFinder findAbonPays2docposesByPaypos(com.hps.july.persistence.AbonentPaymentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
