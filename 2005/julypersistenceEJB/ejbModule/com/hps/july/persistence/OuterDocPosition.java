package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface OuterDocPosition extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInWayBillPosition(com.hps.july.persistence.InWayBillPosition anInWayBillPosition) throws java.rmi.RemoteException;
/**
 * Getter method for configuration
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getConfiguration() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.InwayBill getInWayBill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getInWayBillKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInWayBillPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for note
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNote() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOrder() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOuterDocPosition() throws java.rmi.RemoteException;
/**
 * Getter method for outerPrice
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getOuterPrice() throws java.rmi.RemoteException;
/**
 * Getter method for outerQty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getOuterQty() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetInWayBillKey(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInWayBillPosition(com.hps.july.persistence.InWayBillPosition anInWayBillPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInWayBillPosition(com.hps.july.persistence.InWayBillPosition anInWayBillPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetInWayBill(com.hps.july.persistence.InwayBill anInWayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * Setter method for configuration
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setConfiguration(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setInWayBill(com.hps.july.persistence.InwayBill anInWayBill) throws java.rmi.RemoteException;
/**
 * Setter method for note
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNote(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setOrder(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newOuterDocPosition int
 * @exception String The exception description.
 */
void setOuterDocPosition(int newOuterDocPosition) throws java.rmi.RemoteException;
/**
 * Setter method for outerPrice
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setOuterPrice(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for outerQty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setOuterQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
}
