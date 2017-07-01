package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEDocPosNri extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getCountpolicy() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdrecdocpos() throws java.rmi.RemoteException;
/**
 * Getter method for idresnri
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdresnri() throws java.rmi.RemoteException;
/**
 * Getter method for oldstoragecard
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getOldstoragecard() throws java.rmi.RemoteException;
/**
 * Getter method for partynum
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPartynum() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPartynumplat() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEDocNri getPiedocnri() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEDocNriKey getPiedocnriKey() throws java.rmi.RemoteException;
/**
 * Getter method for price
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getPrice() throws java.rmi.RemoteException;
/**
 * Getter method for qty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getQty() throws java.rmi.RemoteException;
/**
 * Getter method for serialnumplat
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSerialnumplat() throws java.rmi.RemoteException;
/**
 * Getter method for storagecard
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getStoragecard() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPiedocnriKey(com.hps.july.persistence.PIEDocNriKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPiedocnri(com.hps.july.persistence.PIEDocNri aPiedocnri) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setCountpolicy(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idresnri
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdresnri(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for oldstoragecard
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setOldstoragecard(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for partynum
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPartynum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPartynumplat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEDocPosNri2piedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPiedocnri(com.hps.july.persistence.PIEDocNri aPiedocnri) throws java.rmi.RemoteException;
/**
 * Setter method for price
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setPrice(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for serialnumplat
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSerialnumplat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for storagecard
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setStoragecard(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
