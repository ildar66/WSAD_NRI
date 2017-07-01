package com.hps.july.trailcom.beans;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AddressInfo2Home extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.trailcom.beans.AddressInfo2
 * @param argAddressportid int
 * @param argResource int
 * @param argTypeport short
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.trailcom.beans.AddressInfo2 create(int argAddressportid, int argResource, short argTypeport) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAddressInfo2sByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.trailcom.beans.AddressInfo2
 * @param key com.hps.july.trailcom.beans.AddressInfo2Key
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.trailcom.beans.AddressInfo2 findByPrimaryKey(com.hps.july.trailcom.beans.AddressInfo2Key key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByResourceTypeport(Integer argResource, Short argTypeport) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
