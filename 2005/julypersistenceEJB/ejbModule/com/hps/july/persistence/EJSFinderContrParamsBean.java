package com.hps.july.persistence;

/**
 * EJSFinderContrParamsBean
 */
public interface EJSFinderContrParamsBean {
	/**
	 * findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate, java.lang.Integer param_type) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findContrParamsByContraddinfo
	 */
	public com.ibm.ejs.persistence.EJSFinder findContrParamsByContraddinfo(com.hps.july.persistence.ContrAddInfoKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByEquipmentAndActdateOrderByParamlevelAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipmentAndActdateOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
