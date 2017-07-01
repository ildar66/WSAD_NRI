package com.hps.july.persistence;

/**
 * EJSFinderSwitchAddInfoBean
 */
public interface EJSFinderSwitchAddInfoBean {
	/**
	 * findSwitchAddInfosBySwitch
	 */
	public com.ibm.ejs.persistence.EJSFinder findSwitchAddInfosBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByEquipmentOrderByActdateAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipmentOrderByActdateAsc(java.lang.Integer equipment) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
