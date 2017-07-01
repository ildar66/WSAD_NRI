package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: AntennaResource
 */
public interface AntennaResource extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {









/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennaResourceBands() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for anttype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAnttype() throws java.rmi.RemoteException;
/**
 * Getter method for connector
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getConnector() throws java.rmi.RemoteException;
/**
 * Getter method for electricangle
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getElectricangle() throws java.rmi.RemoteException;
/**
 * Getter method for freqrange
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFreqrange() throws java.rmi.RemoteException;
/**
 * Getter method for height
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getHeight() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsomni() throws java.rmi.RemoteException;
/**
 * Getter method for ksvn
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getKsvn() throws java.rmi.RemoteException;
/**
 * Getter method for length
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLength() throws java.rmi.RemoteException;
/**
 * Getter method for polarization
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPolarization() throws java.rmi.RemoteException;
/**
 * Getter method for weight
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getWeight() throws java.rmi.RemoteException;
/**
 * Getter method for width
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getWidth() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennaResourceBands(com.hps.july.persistence.AntennaResourceBand anAntennaResourceBands) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaResourceBand2antres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennaResourceBands(com.hps.july.persistence.AntennaResourceBand anAntennaResourceBands) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * Setter method for anttype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAnttype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for connector
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setConnector(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for electricangle
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setElectricangle(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for freqrange
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFreqrange(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for height
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setHeight(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsomni(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ksvn
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setKsvn(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for length
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLength(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for polarization
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPolarization(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for weight
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setWeight(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for width
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setWidth(java.lang.Integer newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: entriescount
	 */
	public java.lang.Integer getEntriescount() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: entriescount
	 */
	public void setEntriescount(java.lang.Integer newEntriescount)
		throws java.rmi.RemoteException;
}
