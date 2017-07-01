package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AddressSpace extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for activestate
 * @return java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Short getActivestate() throws java.rmi.RemoteException;
/**
 * Getter method for address
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAddress() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.trailcom.beans.AddressInfo getAddressinfo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.trailcom.beans.AddressInfoKey getAddressinfoKey() throws java.rmi.RemoteException;
/**
 * Getter method for disabletime
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getDisabletime() throws java.rmi.RemoteException;
/**
 * Getter method for existstate
 * @return java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Short getExiststate() throws java.rmi.RemoteException;
/**
 * Getter method for insegment
 * @return java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Short getInsegment() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getPortid() throws java.rmi.RemoteException;
/**
 * Getter method for realconnect
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getRealconnect() throws java.rmi.RemoteException;
/**
 * Getter method for storagecard
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getStoragecard() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAddressinfoKey(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException;
/**
 * Setter method for activestate
 * @param newValue java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
void setActivestate(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for address
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAddress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException;
/**
 * Setter method for disabletime
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setDisabletime(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for existstate
 * @param newValue java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
void setExiststate(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for insegment
 * @param newValue java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
void setInsegment(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for realconnect
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setRealconnect(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for storagecard
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setStoragecard(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
