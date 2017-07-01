package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AntennaResourceBand extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for amplification
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getAmplification() throws java.rmi.RemoteException;
/**
 * 
 * @return short
 * @exception String The exception description.
 */
short getBand() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getElectricangle() throws java.rmi.RemoteException;
/**
 * Getter method for horzwidth
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getHorzwidth() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getKsvn() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AntennaResource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for vertwidth
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getVertwidth() throws java.rmi.RemoteException;
/**
 * Setter method for amplification
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setAmplification(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setElectricangle(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for horzwidth
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setHorzwidth(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setKsvn(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for vertwidth
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setVertwidth(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: hasMaxElectricAngle
	 */
	public boolean isHasMaxElectricAngle() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: hasMaxElectricAngle
	 */
	public void setHasMaxElectricAngle(boolean newHasMaxElectricAngle)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: maxelectricangle
	 */
	public java.math.BigDecimal getMaxelectricangle()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: maxelectricangle
	 */
	public void setMaxelectricangle(java.math.BigDecimal newMaxelectricangle)
		throws java.rmi.RemoteException;
}
