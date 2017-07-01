package com.hps.july.persistence;

/**
 * EJSFinderLeaseResBil2NRIBean
 */
public interface EJSFinderLeaseResBil2NRIBean {
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isSubtype, java.lang.Integer subtype, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseResBilsByLeaseResBil
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseResBilsByLeaseResBil(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isIdresbilling, java.lang.String idresbilling, java.lang.Boolean isBillresname, java.lang.String billresname, java.lang.Integer connected, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
