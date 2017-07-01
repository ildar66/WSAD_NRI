package com.hps.july.persistence;
/**
 * Remote interface for Enterprise Bean: RepiterDonorUnits
 */
public interface RepiterDonorUnits extends com.hps.july.persistence.Resource, com.ibm.ivj.ejb.runtime.CopyHelper {













	/**
	 * Get accessor for persistent attribute: power
	 */
	public java.math.BigDecimal getPower() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: power
	 */
	public void setPower(java.math.BigDecimal newPower)
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
	 * Get accessor for persistent attribute: gainfactor
	 */
	public java.math.BigDecimal getGainfactor()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: gainfactor
	 */
	public void setGainfactor(java.math.BigDecimal newGainfactor)
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
	 * Get accessor for persistent attribute: usedpower
	 */
	public java.math.BigDecimal getUsedpower() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: usedpower
	 */
	public void setUsedpower(java.math.BigDecimal newUsedpower)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: entriescount
	 */
	public java.lang.Integer getEntriescount() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: entriescount
	 */
	public void setEntriescount(java.lang.Integer newEntriescount)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: antgatescount
	 */
	public java.lang.Integer getAntgatescount()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: antgatescount
	 */
	public void setAntgatescount(java.lang.Integer newAntgatescount)
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
}
