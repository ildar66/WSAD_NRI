package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEDocPosNriHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEDocPosNri
 * @param argIdrecdocpos int
 * @param argIdRecDoc int
 * @param argIdResNri int
 * @param argQty java.math.BigDecimal
 * @param argCountpolicy java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEDocPosNri create(int argIdrecdocpos, int argIdRecDoc, int argIdResNri, java.math.BigDecimal argQty, java.lang.String argCountpolicy) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEDocPosNri
 * @param key com.hps.july.persistence.PIEDocPosNriKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEDocPosNri findByPrimaryKey(com.hps.july.persistence.PIEDocPosNriKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPIEDocPosNrisByPiedocnri(com.hps.july.persistence.PIEDocNriKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
