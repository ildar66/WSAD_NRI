package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ContrParamsHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ContrParams
 * @param argParamid int
 * @param argEquipment int
 * @param argActDate java.sql.Date
 * @param argParamLevel java.math.BigDecimal
 * @param argParamValue java.math.BigDecimal
 * @param argParam_type int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ContrParams create(int argParamid, int argEquipment, java.sql.Date argActDate, java.math.BigDecimal argParamLevel, java.math.BigDecimal argParamValue, int argParam_type) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
	Integer equipment, java.sql.Date actdate, Integer param_type)
 		throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByEquipmentAndActdateOrderByParamlevelAsc(Integer equipment, java.sql.Date actdate)
 		throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ContrParams
 * @param key com.hps.july.persistence.ContrParamsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ContrParams findByPrimaryKey(com.hps.july.persistence.ContrParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findContrParamsByContraddinfo(com.hps.july.persistence.ContrAddInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
