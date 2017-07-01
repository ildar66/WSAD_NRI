package com.hps.july.persistence;

/**
 * EJSFinderContrAddInfoBean
 */
public interface EJSFinderContrAddInfoBean {
	/**
	 * findContrAddInfosByController
	 */
	public com.ibm.ejs.persistence.EJSFinder findContrAddInfosByController(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByEquipmentOrderByActdateAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipmentOrderByActdateAsc(java.lang.Integer equipment) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
