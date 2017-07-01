package com.hps.july.persistence;

/**
 * EJSFinderLeaseMutualRuleNewBean
 */
public interface EJSFinderLeaseMutualRuleNewBean {
	/**
	 * findLeaseMutualRuleNewsByReglamentOrderByResourceAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(java.lang.Integer argreglament) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMutualRuleNewsByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualRuleNewsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMutualRulesByReglament
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualRulesByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
