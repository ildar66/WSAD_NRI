package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEResPlatinumHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEResPlatinum
 * @param argIdresplatinum java.lang.String
 * @param argOwner int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEResPlatinum create(java.lang.String argIdresplatinum, int argOwner, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByIdresplatinNameOwner(Boolean isIdresplatin, String idresplatin, 
	Boolean isNameRes, String nameRes, Integer owner,
	Integer order)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEResPlatinum
 * @param key com.hps.july.persistence.PIEResPlatinumKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEResPlatinum findByPrimaryKey(com.hps.july.persistence.PIEResPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
