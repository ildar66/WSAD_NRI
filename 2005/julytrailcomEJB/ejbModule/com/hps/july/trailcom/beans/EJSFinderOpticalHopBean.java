package com.hps.july.trailcom.beans;

/**
 * EJSFinderOpticalHopBean
 */
public interface EJSFinderOpticalHopBean {
	/**
	 * findOpticalHopByHopid
	 */
	public com.hps.july.trailcom.beans.OpticalHop findOpticalHopByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
