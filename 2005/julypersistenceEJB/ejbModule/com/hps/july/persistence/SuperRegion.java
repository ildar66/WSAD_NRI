package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SuperRegion extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRegion() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSuperRegionAccs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSupregcode() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSupregid() throws java.rmi.RemoteException;
/**
 * Getter method for supregname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSupregname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SuperRegionAcc2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSuperRegionAccs(com.hps.july.persistence.SuperRegionAcc aSuperRegionAccs) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setSupregcode(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for supregname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSupregname(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: country
	 */
	public int getCountry() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: country
	 */
	public void setCountry(int newCountry) throws java.rmi.RemoteException;
}
