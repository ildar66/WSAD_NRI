package com.hps.july.trailcom.beans;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AddressInfoHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.trailcom.beans.AddressInfo
 * @param argResource int
 * @param argTypeport short
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.trailcom.beans.AddressInfo create(int argResource, short argTypeport) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.trailcom.beans.AddressInfo
 * @param key com.hps.july.trailcom.beans.AddressInfoKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.trailcom.beans.AddressInfo findByPrimaryKey(com.hps.july.trailcom.beans.AddressInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByResource(Integer argResource) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
