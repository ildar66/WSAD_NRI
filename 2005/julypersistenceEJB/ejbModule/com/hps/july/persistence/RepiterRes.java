package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: RepiterRes
 */
public interface RepiterRes extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {













/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * Getter method for bandwidth
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getBandwidth() throws java.rmi.RemoteException;
/**
 * Getter method for islinear
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getIslinear() throws java.rmi.RemoteException;
/**
 * Getter method for numchanals
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getNumchanals() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRepiters() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for reppower
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getReppower() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * Setter method for bandwidth
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setBandwidth(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for islinear
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIslinear(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for numchanals
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumchanals(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for reppower
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setReppower(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: endbandwidth
	 */
	public java.math.BigDecimal getEndbandwidth()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: endbandwidth
	 */
	public void setEndbandwidth(java.math.BigDecimal newEndbandwidth)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: dimensions
	 */
	public java.lang.String getDimensions() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: dimensions
	 */
	public void setDimensions(java.lang.String newDimensions)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: weight
	 */
	public java.math.BigDecimal getWeight() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: weight
	 */
	public void setWeight(java.math.BigDecimal newWeight)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: usedpower
	 */
	public java.math.BigDecimal getUsedpower() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: usedpower
	 */
	public void setUsedpower(java.math.BigDecimal newUsedpower)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: gainfactor
	 */
	public java.lang.Integer getGainfactor() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: gainfactor
	 */
	public void setGainfactor(java.lang.Integer newGainfactor)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: signaldelay
	 */
	public java.math.BigDecimal getSignaldelay()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: signaldelay
	 */
	public void setSignaldelay(java.math.BigDecimal newSignaldelay)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: noisefactor
	 */
	public java.math.BigDecimal getNoisefactor()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: noisefactor
	 */
	public void setNoisefactor(java.math.BigDecimal newNoisefactor)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: workband
	 */
	public java.lang.Integer getWorkband() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: workband
	 */
	public void setWorkband(java.lang.Integer newWorkband)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: linkband
	 */
	public java.lang.Integer getLinkband() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: linkband
	 */
	public void setLinkband(java.lang.Integer newLinkband)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: voltageid
	 */
	public java.lang.Integer getVoltageid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: voltageid
	 */
	public void setVoltageid(java.lang.Integer newVoltageid)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: repitertype
	 */
	public java.lang.Integer getRepitertype() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: repitertype
	 */
	public void setRepitertype(java.lang.Integer newRepitertype)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: antentriescount
	 */
	public java.lang.Integer getAntentriescount()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: antentriescount
	 */
	public void setAntentriescount(java.lang.Integer newAntentriescount)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: downlinkband
	 */
	public java.lang.Integer getDownlinkband() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: downlinkband
	 */
	public void setDownlinkband(java.lang.Integer newDownlinkband)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: downlinkbandup
	 */
	public java.lang.Integer getDownlinkbandup()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: downlinkbandup
	 */
	public void setDownlinkbandup(java.lang.Integer newDownlinkbandup)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: remotecontrol
	 */
	public java.lang.Boolean getRemotecontrol()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: remotecontrol
	 */
	public void setRemotecontrol(java.lang.Boolean newRemotecontrol)
		throws java.rmi.RemoteException;
}
