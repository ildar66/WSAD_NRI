package com.hps.july.persistence;

/**
 * EJSFinderSwitchParamsBean
 */
public interface EJSFinderSwitchParamsBean {
	/**
	 * findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate, java.lang.Integer param_type) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSwitchParamsBySwitchaddinfo
	 */
	public com.ibm.ejs.persistence.EJSFinder findSwitchParamsBySwitchaddinfo(com.hps.july.persistence.SwitchAddInfoKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByEquipmentAndActdateOrderByParamlevelAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipmentAndActdateOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
