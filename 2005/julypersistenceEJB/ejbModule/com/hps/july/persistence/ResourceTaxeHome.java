package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ResourceTaxeHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ResourceTaxe
 * @param argResource com.hps.july.persistence.ResourceKey
 * @param argDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ResourceTaxe create(com.hps.july.persistence.ResourceKey argResource, java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ResourceTaxe
 * @param argDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ResourceTaxe create(java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ResourceTaxe
 * @param argDate java.sql.Date
 * @param argResource java.lang.Integer
 * @param argNds java.math.BigDecimal
 * @param argNsp java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ResourceTaxe create(java.sql.Date argDate, java.lang.Integer argResource, java.math.BigDecimal argNds, java.math.BigDecimal argNsp) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ResourceTaxe
 * @param key com.hps.july.persistence.ResourceTaxeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ResourceTaxe findByPrimaryKey(com.hps.july.persistence.ResourceTaxeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByResourceOrderByDateDesc( Integer resource ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findBySubtypeDateOrderByResourceAsc( Integer ressubtype, java.sql.Date date ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findResourceTaxesByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
