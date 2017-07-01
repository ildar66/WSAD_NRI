package com.hps.july.persistence;

/**
 * EJSFinderLeasePosSchetFaktBean
 */
public interface EJSFinderLeasePosSchetFaktBean {
	/**
	 * findLeasePosSchetFaktByResourceNri
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeasePosSchetFaktByResourceNri(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdSchetFaktOrderByPosorderDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdSchetFaktOrderByPosorderDesc(java.lang.Integer idSchetFact) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeasePosSchetFaktsByIdSchetFakt
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeasePosSchetFaktsByIdSchetFakt(com.hps.july.persistence.LeaseSchetFaktKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdSchetFaktOrderByPosorderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdSchetFaktOrderByPosorderAsc(java.lang.Integer idSchetFact) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
