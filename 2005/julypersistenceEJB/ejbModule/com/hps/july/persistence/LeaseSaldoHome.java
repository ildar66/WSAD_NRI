package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseSaldoHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseSaldo
 * @param argLeaseContract java.lang.Integer
 * @param argSalDate java.sql.Date
 * @param argResource java.lang.Integer
 * @param argMainCurrency java.lang.Integer
 * @param argMainSum java.math.BigDecimal
 * @param argMainNdsSum java.math.BigDecimal
 * @param argIsTemp java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseSaldo create(java.lang.Integer argLeaseContract, java.sql.Date argSalDate, java.lang.Integer argResource, java.lang.Integer argMainCurrency, java.math.BigDecimal argMainSum, java.math.BigDecimal argMainNdsSum, java.lang.Boolean argIsTemp) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByLeaseContractAndResourceOrderDateAsc(Integer leaseContract, Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByLeaseContractAndResourceOrderDateDesc(Integer leaseContract, Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseSaldo
 * @param key com.hps.july.persistence.LeaseSaldoKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseSaldo findByPrimaryKey(com.hps.july.persistence.LeaseSaldoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Integer leaseContract,
		Boolean isDateStart,
        java.sql.Date fromDateStart, java.sql.Date toDateStart, /*диапазон для dateStart*/
        Integer order
    ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseSaldoAddsByAdditionalcurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseSaldoByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseSaldoMainsByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseSaldosByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
