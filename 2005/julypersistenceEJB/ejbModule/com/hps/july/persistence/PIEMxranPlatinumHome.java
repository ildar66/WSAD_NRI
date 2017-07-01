package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEMxranPlatinumHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEMxranPlatinum
 * @param argMxranplatinum java.lang.String
 * @param argOwner int
 * @param argStatus java.lang.String
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEMxranPlatinum create(java.lang.String argMxranplatinum, int argOwner, java.lang.String argStatus, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByMxranNameOwner(Boolean isMxranPlatinum, String mxranplatinum,
		Boolean isName, String name, 
		Integer owner, Integer order)
 throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEMxranPlatinum
 * @param key com.hps.july.persistence.PIEMxranPlatinumKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEMxranPlatinum findByPrimaryKey(com.hps.july.persistence.PIEMxranPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPIEMxranPlatinumsByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
