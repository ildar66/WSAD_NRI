package com.hps.july.persistence;

/**
 * EJSFinderLeasePay2BillBean
 */
public interface EJSFinderLeasePay2BillBean {
	/**
	 * findByAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findByAct(java.lang.Integer argAct) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByFlagWorkPIE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByFlagWorkPIE(java.lang.String argFlagWorkPIE) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
