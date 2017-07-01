package com.hps.july.persistence;

/**
 * EJSFinderAntennaBean
 */
public interface EJSFinderAntennaBean {
	/**
	 * findAntennesByOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntennesByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer argBSNum, java.lang.String bsType, java.lang.Boolean isPlanstate, java.lang.String argPlanstate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAntennesByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntennesByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findGrresAntennesByGroundresource
	 */
	public com.ibm.ejs.persistence.EJSFinder findGrresAntennesByGroundresource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAntennesByEquipment
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntennesByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAntennesByCableres
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntennesByCableres(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByEquipmentOrderByNumAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipmentOrderByNumAsc(java.lang.Integer argEquipment) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
