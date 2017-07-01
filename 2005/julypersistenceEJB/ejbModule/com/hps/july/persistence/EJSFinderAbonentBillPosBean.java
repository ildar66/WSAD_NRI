package com.hps.july.persistence;

/**
 * EJSFinderAbonentBillPosBean
 */
public interface EJSFinderAbonentBillPosBean {
	/**
	 * findAbonentBillPosesByPos2resource
	 */
	public com.ibm.ejs.persistence.EJSFinder findAbonentBillPosesByPos2resource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseBill
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseBill(java.lang.Integer leaseBill) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAbonentBillPosesByPos2currency
	 */
	public com.ibm.ejs.persistence.EJSFinder findAbonentBillPosesByPos2currency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAbonentBillPosesByPos2bill
	 */
	public com.ibm.ejs.persistence.EJSFinder findAbonentBillPosesByPos2bill(com.hps.july.persistence.AbonentBillKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
