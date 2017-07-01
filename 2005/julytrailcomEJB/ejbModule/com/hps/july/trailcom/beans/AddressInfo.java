package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AddressInfo extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAddressInfo2s(com.hps.july.trailcom.beans.AddressInfo2 anAddressInfo2s) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAddressSpaces(com.hps.july.trailcom.beans.AddressSpace anAddressSpaces) throws java.rmi.RemoteException;
/**
 * Getter method for addresshead
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAddresshead() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAddressInfo2s() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAddressSpaces() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for addressstep
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getAddressstep() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getAddresstype() throws java.rmi.RemoteException;
/**
 * Getter method for e1count
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getE1count() throws java.rmi.RemoteException;
/**
 * Getter method for lastaddress
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLastaddress() throws java.rmi.RemoteException;
/**
 * Getter method for maxconnect
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getMaxconnect() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getResource() throws java.rmi.RemoteException;
/**
 * Getter method for startaddress
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getStartaddress() throws java.rmi.RemoteException;
/**
 * 
 * @return short
 * @exception String The exception description.
 */
short getTypeport() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAddressInfo2s(com.hps.july.trailcom.beans.AddressInfo2 anAddressInfo2s) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAddressSpaces(com.hps.july.trailcom.beans.AddressSpace anAddressSpaces) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressInfo22addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAddressInfo2s(com.hps.july.trailcom.beans.AddressInfo2 anAddressInfo2s) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AddressSpace2addressinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAddressSpaces(com.hps.july.trailcom.beans.AddressSpace anAddressSpaces) throws java.rmi.RemoteException;
/**
 * Setter method for addresshead
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAddresshead(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for addressstep
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setAddressstep(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setAddresstype(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for e1count
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setE1count(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for lastaddress
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLastaddress(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for maxconnect
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setMaxconnect(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for startaddress
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setStartaddress(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
