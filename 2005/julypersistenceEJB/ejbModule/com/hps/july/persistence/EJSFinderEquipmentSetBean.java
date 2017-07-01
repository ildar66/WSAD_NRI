package com.hps.july.persistence;

/**
 * EJSFinderEquipmentSetBean
 */
public interface EJSFinderEquipmentSetBean {
	/**
	 * findEquipmentSetByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findEquipmentSetByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPlatinumAndStatus
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPlatinumAndStatus(java.lang.Integer position, java.lang.Integer owner, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
