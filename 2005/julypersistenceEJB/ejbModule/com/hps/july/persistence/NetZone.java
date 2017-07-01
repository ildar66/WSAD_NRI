package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface NetZone extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getNetzone() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getRegionid() throws java.rmi.RemoteException;
/**
 * Getter method for zonecode
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getZonecode() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newNetzone int
 * @exception String The exception description.
 */
void setNetzone(int newNetzone) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setRegionid(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for zonecode
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setZonecode(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: tcode
	 */
	public java.math.BigDecimal getTcode() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: tcode
	 */
	public void setTcode(java.math.BigDecimal newTcode)
		throws java.rmi.RemoteException;
}
