package com.hps.july.persistence;

/**
 * EJSFinderSectorBean
 */
public interface EJSFinderSectorBean {
	/**
	 * findByBasestationOrderByNumberAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByBasestationOrderByNumberAsc(java.lang.Integer argEquipment) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer argBSNum, java.lang.String bsType, java.lang.Boolean isPlanstate, java.lang.String argPlanstate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSectorsByEquipment
	 */
	public com.ibm.ejs.persistence.EJSFinder findSectorsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
