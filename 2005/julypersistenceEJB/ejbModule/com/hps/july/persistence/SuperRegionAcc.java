package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SuperRegionAcc extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getAccessid() throws java.rmi.RemoteException;
/**
 * Getter method for editfact
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getEditfact() throws java.rmi.RemoteException;
/**
 * Getter method for editplan
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getEditplan() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Operator getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OperatorKey getOperatorKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SuperRegion getSuperregion() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SuperRegionKey getSuperregionKey() throws java.rmi.RemoteException;
/**
 * Getter method for viewfact
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getViewfact() throws java.rmi.RemoteException;
/**
 * Getter method for viewplan
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getViewplan() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSuperregionKey(com.hps.july.persistence.SuperRegionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSuperregion(com.hps.july.persistence.SuperRegion aSuperregion) throws java.rmi.RemoteException;
/**
 * Setter method for editfact
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setEditfact(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for editplan
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setEditplan(boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSuperregion(com.hps.july.persistence.SuperRegion aSuperregion) throws java.rmi.RemoteException;
/**
 * Setter method for viewfact
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setViewfact(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for viewplan
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setViewplan(boolean newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: viewarenda
	 */
	public java.lang.Boolean getViewarenda() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: viewarenda
	 */
	public void setViewarenda(java.lang.Boolean newViewarenda)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: editarenda
	 */
	public java.lang.Boolean getEditarenda() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: editarenda
	 */
	public void setEditarenda(java.lang.Boolean newEditarenda)
		throws java.rmi.RemoteException;
}
