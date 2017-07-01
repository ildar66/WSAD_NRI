package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: CableResource
 */
public interface CableResource extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {









/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCableResourceBands() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCableResourceBands(com.hps.july.persistence.CableResourceBand aCableResourceBands) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCableResourceBands(com.hps.july.persistence.CableResourceBand aCableResourceBands) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: cablediamid
	 */
	public int getCablediamid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: cablediamid
	 */
	public void setCablediamid(int newCablediamid)
		throws java.rmi.RemoteException;
}
