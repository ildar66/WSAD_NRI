package com.hps.july.persistence;

/**
 * EJSRemoteCMPCardTrack
 */
public class EJSRemoteCMPCardTrack extends com.hps.july.persistence.EJSRemoteCMPCardTrack_f33ec78d implements CardTrack {
	/**
	 * EJSRemoteCMPCardTrack
	 */
	public EJSRemoteCMPCardTrack() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return new com.ibm.ejs.container.EJSDeployedSupport();
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		return;
	}
}
