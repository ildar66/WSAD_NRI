package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AssemblingAct extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getAgregat() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAgregateresource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getAgregateserial() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getAgregatKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getMonter() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getMonterKey() throws java.rmi.RemoteException;
/**
 * Getter method for newConfiguration
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNewConfiguration() throws java.rmi.RemoteException;
/**
 * Getter method for oldConfiguration
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOldConfiguration() throws java.rmi.RemoteException;
/**
 * Getter method for operationType
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOperationType() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getUnmountblocks() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAgregatKey(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetMonterKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAgregat(com.hps.july.persistence.StorageCard anAgregat) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAgregat(com.hps.july.persistence.StorageCard anAgregat) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAgregateresource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setAgregateserial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException;
/**
 * Setter method for newConfiguration
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNewConfiguration(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for oldConfiguration
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOldConfiguration(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for operationType
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOperationType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setUnmountblocks(java.lang.Boolean newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: inventserial
	 */
	public java.lang.String getInventserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: inventserial
	 */
	public void setInventserial(java.lang.String newInventserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: localserial
	 */
	public java.lang.String getLocalserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: localserial
	 */
	public void setLocalserial(java.lang.String newLocalserial)
		throws java.rmi.RemoteException;
}
