package com.hps.july.persistence;

/**
 * EJSFinderComEquipmentBean
 */
public interface EJSFinderComEquipmentBean {
	/**
	 * findByPositionType
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPositionType(java.lang.Integer argPosition, java.lang.String argType, java.lang.Integer argOrder) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findComEquipmentsByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findComEquipmentsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
