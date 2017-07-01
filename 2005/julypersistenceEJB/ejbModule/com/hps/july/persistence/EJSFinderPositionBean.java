package com.hps.july.persistence;

/**
 * EJSFinderPositionBean
 */
public interface EJSFinderPositionBean {
	/**
	 * findByQBE4
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE4(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPositionsByRegion
	 */
	public com.ibm.ejs.persistence.EJSFinder findPositionsByRegion(com.hps.july.persistence.RegionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRenteePositionByRenter
	 */
	public com.ibm.ejs.persistence.EJSFinder findRenteePositionByRenter(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPositionByNetZone
	 */
	public com.ibm.ejs.persistence.EJSFinder findPositionByNetZone(com.hps.july.persistence.NetZoneKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE3
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE3(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Boolean isInAction, java.lang.String inAction, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
