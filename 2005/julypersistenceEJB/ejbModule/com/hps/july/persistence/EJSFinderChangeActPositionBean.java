package com.hps.july.persistence;

/**
 * EJSFinderChangeActPositionBean
 */
public interface EJSFinderChangeActPositionBean {
	/**
	 * findByDocNewSerial
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocNewSerial(java.lang.Integer argDoc, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findChangeActPositionByChangeAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findChangeActPositionByChangeAct(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findChangeActPositionsByNewresource
	 */
	public com.ibm.ejs.persistence.EJSFinder findChangeActPositionsByNewresource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
