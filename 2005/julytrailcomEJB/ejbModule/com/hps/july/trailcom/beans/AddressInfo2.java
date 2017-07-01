package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AddressInfo2 extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.trailcom.beans.AddressInfo getAddressinfo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.trailcom.beans.AddressInfoKey getAddressinfoKey() throws java.rmi.RemoteException;
/**
 * Getter method for addressname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAddressname() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getAddressportid() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAddressinfoKey(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException;
/**
 * Setter method for addressname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAddressname(java.lang.String newValue) throws java.rmi.RemoteException;
}
