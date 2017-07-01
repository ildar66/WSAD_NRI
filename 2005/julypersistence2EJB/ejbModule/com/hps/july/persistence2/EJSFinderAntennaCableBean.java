package com.hps.july.persistence2;

/**
 * EJSFinderAntennaCableBean
 */
public interface EJSFinderAntennaCableBean {
	/**
	 * findByAnten
	 */
	public com.ibm.ejs.persistence.EJSFinder findByAnten(java.lang.Integer argAntenId) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
