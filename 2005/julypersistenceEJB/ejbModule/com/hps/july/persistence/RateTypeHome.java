package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RateTypeHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.RateType
 * @param argRatetype int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.RateType create(int argRatetype) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.RateType
 * @param argRatetype int
 * @param argName java.lang.String
 * @param argBaseCurrency java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.RateType create(int argRatetype, java.lang.String argName, java.lang.Integer argBaseCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.RateType
 * @param key com.hps.july.persistence.RateTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.RateType findByPrimaryKey(com.hps.july.persistence.RateTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRateTypeByBasecurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
