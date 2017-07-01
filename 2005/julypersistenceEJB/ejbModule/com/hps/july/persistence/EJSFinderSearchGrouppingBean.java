package com.hps.july.persistence;

/**
 * EJSFinderSearchGrouppingBean
 */
public interface EJSFinderSearchGrouppingBean {
	/**
	 * findSearchGrouppingBySearchGroup
	 */
	public com.ibm.ejs.persistence.EJSFinder findSearchGrouppingBySearchGroup(com.hps.july.persistence.SearchGroupKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
