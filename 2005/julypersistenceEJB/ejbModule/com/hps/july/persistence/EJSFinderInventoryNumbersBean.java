package com.hps.july.persistence;

/**
 * EJSFinderInventoryNumbersBean
 */
public interface EJSFinderInventoryNumbersBean {
	/**
	 * findOrderBySerstartAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrderBySerstartAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrderBySerprefixDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrderBySerprefixDesc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInventoryNumbersBySerworker
	 */
	public com.ibm.ejs.persistence.EJSFinder findInventoryNumbersBySerworker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrderBySerstartDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrderBySerstartDesc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrderBySerprefixAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrderBySerprefixAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
