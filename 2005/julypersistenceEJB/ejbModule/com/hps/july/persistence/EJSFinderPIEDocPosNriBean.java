package com.hps.july.persistence;

/**
 * EJSFinderPIEDocPosNriBean
 */
public interface EJSFinderPIEDocPosNriBean {
	/**
	 * findPIEDocPosNrisByPiedocnri
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEDocPosNrisByPiedocnri(com.hps.july.persistence.PIEDocNriKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
