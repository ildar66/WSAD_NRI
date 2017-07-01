package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEPayNRIHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEPayNRI
 * @param argId int
 * @param argQuery int
 * @param argTypeDogov java.lang.String
 * @param argIdDogovNri int
 * @param argIdAccount int
 * @param argDateCreate java.sql.Date
 * @param argSumPay java.math.BigDecimal
 * @param argNdsPay java.math.BigDecimal
 * @param argValute int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEPayNRI create(int argId, int argQuery, java.lang.String argTypeDogov, int argIdDogovNri, int argIdAccount, java.sql.Date argDateCreate, java.math.BigDecimal argSumPay, java.math.BigDecimal argNdsPay, int argValute) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEPayNRI
 * @param key com.hps.july.persistence.PIEPayNRIKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEPayNRI findByPrimaryKey(com.hps.july.persistence.PIEPayNRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEPayNRI2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPIEPayNRIsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
