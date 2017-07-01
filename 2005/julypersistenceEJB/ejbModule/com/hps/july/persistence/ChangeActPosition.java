package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ChangeActPosition extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ChangeAct getChangeAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DocumentKey getChangeActKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getCode() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getManufserial() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getNewresource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getNewresourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for newSerial
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNewSerial() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOldmanufserial() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOldresource() throws java.rmi.RemoteException;
/**
 * Getter method for oldSerial
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOldSerial() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetChangeActKey(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetNewresourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetChangeAct(com.hps.july.persistence.ChangeAct aChangeAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetNewresource(com.hps.july.persistence.Resource aNewresource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setChangeAct(com.hps.july.persistence.ChangeAct aChangeAct) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newCode int
 * @exception String The exception description.
 */
void setCode(int newCode) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setManufserial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setNewresource(com.hps.july.persistence.Resource aNewresource) throws java.rmi.RemoteException;
/**
 * Setter method for newSerial
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNewSerial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setOldmanufserial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setOldresource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for oldSerial
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOldSerial(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: localserial
	 */
	public java.lang.String getLocalserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: localserial
	 */
	public void setLocalserial(java.lang.String newLocalserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: oldlocalserial
	 */
	public java.lang.String getOldlocalserial()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: oldlocalserial
	 */
	public void setOldlocalserial(java.lang.String newOldlocalserial)
		throws java.rmi.RemoteException;
}
