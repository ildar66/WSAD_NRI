package com.hps.july.persistence;

/**
 * EJSFinderAbonBillpos2docposBean
 */
public interface EJSFinderAbonBillpos2docposBean {
	/**
	 * findAbonBillpos2docposByLeasedocposition
	 */
	public com.hps.july.persistence.AbonBillpos2docpos findAbonBillpos2docposByLeasedocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAbonBillpos2docposesByBillpos
	 */
	public com.ibm.ejs.persistence.EJSFinder findAbonBillpos2docposesByBillpos(com.hps.july.persistence.AbonentBillPosKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
