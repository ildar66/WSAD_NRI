package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: InWayBillPosition
 */
public interface InWayBillPosition extends com.hps.july.persistence.DocumentPosition, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OuterDocPosition getOuterDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OuterDocPositionKey getOuterDocPositionKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSourcePrice() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOuterDocPositionKey(com.hps.july.persistence.OuterDocPositionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InWayBillPosition2OuterDocPosition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSourcePrice(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
