package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SwitchParamsHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.SwitchParams
 * @param argParamid int
 * @param argEquipment int
 * @param argActDate java.sql.Date
 * @param argParamLevel java.math.BigDecimal
 * @param argParamValue java.math.BigDecimal
 * @param argParam_type int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SwitchParams create(int argParamid, int argEquipment, java.sql.Date argActDate, java.math.BigDecimal argParamLevel, java.math.BigDecimal argParamValue, int argParam_type) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
	Integer equipment, java.sql.Date actdate, Integer param_type)
 throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByEquipmentAndActdateOrderByParamlevelAsc(Integer equipment, java.sql.Date actdate)
 throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SwitchParams
 * @param key com.hps.july.persistence.SwitchParamsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SwitchParams findByPrimaryKey(com.hps.july.persistence.SwitchParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSwitchParamsBySwitchaddinfo(com.hps.july.persistence.SwitchAddInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
