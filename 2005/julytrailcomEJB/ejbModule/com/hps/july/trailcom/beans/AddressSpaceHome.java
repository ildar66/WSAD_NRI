package com.hps.july.trailcom.beans;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AddressSpaceHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.trailcom.beans.AddressSpace
 * @param argPortid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.trailcom.beans.AddressSpace create(int argPortid) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAddressSpacesByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.trailcom.beans.AddressSpace
 * @param key com.hps.july.trailcom.beans.AddressSpaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.trailcom.beans.AddressSpace findByPrimaryKey(com.hps.july.trailcom.beans.AddressSpaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByStoragecard(Integer argStoragecard) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
