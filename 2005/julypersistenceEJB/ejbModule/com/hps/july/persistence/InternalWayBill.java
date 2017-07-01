package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: InternalWayBill
 */
public interface InternalWayBill extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * Getter method for fixing
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getFixing() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getMonter() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getMonterKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetMonterKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * Setter method for fixing
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setFixing(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: equiptype
	 */
	public java.lang.String getEquiptype() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: equiptype
	 */
	public void setEquiptype(java.lang.String newEquiptype)
		throws java.rmi.RemoteException;
}
