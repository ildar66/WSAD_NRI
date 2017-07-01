package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseAbonentPhone extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getBen() throws java.rmi.RemoteException;
/**
 * Getter method for imsi
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getImsi() throws java.rmi.RemoteException;
/**
 * Getter method for netstandard
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNetstandard() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseAbonentBAN getPhone2ban() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getPhone2banKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPhonenumber() throws java.rmi.RemoteException;
/**
 * Getter method for phonestatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPhonestatus() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setBen(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for imsi
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setImsi(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for netstandard
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNetstandard(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for phonestatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPhonestatus(java.lang.String newValue) throws java.rmi.RemoteException;
}
